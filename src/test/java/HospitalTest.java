import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Arrays;

public class HospitalTest {

    private HospitalVisit hospital1;
    private HospitalVisit hospital2;
    private Patient p1;
    private  Patient p2;


    @BeforeClass
    public void CreatePatientAndTheirDetails(){
        hospital1=new HospitalVisit("Lifeline","Mumbai", Arrays.asList(LocalDate.now(),LocalDate.of(2021,10,1),LocalDate.of(2021,4,1),LocalDate.of(2021,2,1)));
        hospital2=new HospitalVisit("Lifeline","Pune",Arrays.asList(LocalDate.now(),LocalDate.of(2021,10,1),LocalDate.of(2021,4,1),LocalDate.of(2021,2,1)));
        p1= new Patient(1,"Amit","Mumbai",Arrays.asList(hospital1,hospital2));
        p2= new Patient(2,"Nikhil","Pune",Arrays.asList(hospital1,hospital2));
    }
    @Test
    public void TestTotalVisitedCount(){
        Assert.assertEquals(8,p1.Visitcount("Lifeline"));
    }
    @Test
    public void TestLastThreeDaysVisit(){
        Assert.assertEquals(1,hospital1.getlastNodaysVisit(3));
    }
    @Test
    public void TestTotalVisitDuringRange(){
        LocalDate date=LocalDate.now();
        Assert.assertEquals(1,hospital1.getVisitDuringATimeRange(date.minusDays(5),date.plusDays(5)));
    }
    @Test
    public void TestPatientInsidePune(){
        HospitalVisit hospital_Mumbai=new HospitalVisit("kmc","Mumbai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,10,1),LocalDate.of(2021,4,1),LocalDate.of(2021,2,1)));
        HospitalVisit hospital_Pune=new HospitalVisit("kmc","Pune",Arrays.asList(LocalDate.now(),LocalDate.of(2021,10,1),LocalDate.of(2021,4,1),LocalDate.of(2021,2,1)));

        Patient p=new Patient(1,"Vinay","Mumbai",Arrays.asList(hospital_Pune,hospital_Mumbai));
        Patient p2=new Patient(2,"Danush","Pune",Arrays.asList(hospital_Pune,hospital_Mumbai));
        Patient p1=new Patient(3,"Ramu","Goa",Arrays.asList(hospital_Pune,hospital_Mumbai));
        Hospital hospital=new Hospital("Pune","Lifeline",Arrays.asList(p,p1,p2));
        Assert.assertEquals(2,hospital.getPatientOutsidePune("Pune"));
    }

    @Test
    public void testPatientOutsidePune(){
        HospitalVisit hospital_Mumbai=new HospitalVisit("kmc","Mumbai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,10,1),LocalDate.of(2021,4,1),LocalDate.of(2021,2,1)));
        HospitalVisit hospital_Pune=new HospitalVisit("kmc","Pune",Arrays.asList(LocalDate.now(),LocalDate.of(2021,10,1),LocalDate.of(2021,4,1),LocalDate.of(2021,2,1)));

        Patient p=new Patient(1,"Vinay","Mumbai",Arrays.asList(hospital_Pune,hospital_Mumbai));
        Patient p2=new Patient(2,"Danush","Pune",Arrays.asList(hospital_Pune,hospital_Mumbai));
        Patient p1=new Patient(3,"Ramu","Goa",Arrays.asList(hospital_Pune,hospital_Mumbai));
        Hospital hospital=new Hospital("Pune","Lifeline",Arrays.asList(p,p1,p2));
        Assert.assertEquals(2,hospital.getPatientOutsidePune("Pune"));
    }
    public void testPatientRatio(){
        HospitalVisit hospital_Mumbai=new HospitalVisit("kmc","Mumbai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,10,1),LocalDate.of(2021,4,1),LocalDate.of(2021,2,1)));
        HospitalVisit hospital_Pune=new HospitalVisit("Sparsh","Pune",Arrays.asList(LocalDate.now(),LocalDate.of(2021,10,1),LocalDate.of(2021,4,1),LocalDate.of(2021,2,1)));
        Patient p=new Patient(1,"Vinay","Mumbai",Arrays.asList(hospital_Pune,hospital_Mumbai));
        Patient p2=new Patient(2,"Danush","Pune",Arrays.asList(hospital_Pune,hospital_Mumbai));
        Patient p1=new Patient(3,"Ramu","Goa",Arrays.asList(hospital_Pune,hospital_Mumbai));

        Hospital hospital=new Hospital("Pune","Sparsh",Arrays.asList(p,p1,p2));
        Assert.assertEquals(3,hospital.getRatioInsideToOutside("Pune"),4);

    }
}
