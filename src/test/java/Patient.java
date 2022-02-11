import java.time.LocalDate;
import java.util.List;

public class Patient {
    private int patientId;
    private String name;
    private String location;
    private List<HospitalVisit> hospitalVisits;

    Patient(int patientId,String name,String location,List<HospitalVisit> hospitalVisits){
        this.patientId=patientId;
        this.name=name;
        this.location=location;
        this.hospitalVisits=hospitalVisits;
    }
    public int Visitcount(String hospitalname){
        int count=0;
        List<HospitalVisit>hospitalVisits=this.hospitalVisits;
        for (HospitalVisit hospitalVisit:hospitalVisits){
            if(hospitalVisit.hospitalname.equals(hospitalname))
                count=count+hospitalVisit.getTotalVisit();
        }
        return count;
    }
    public long getTotalVisitWithArange(LocalDate date1, LocalDate date2){
        long count=0;
        for (HospitalVisit hospitalVisit:hospitalVisits){
            List<LocalDate>dates=hospitalVisit.getDates();
            count=count+dates.stream().filter((s)->s.isAfter(date1)&&s.isBefore(date2)).count();
        }
        return count;
    }
    public int getId(){return this.patientId;}
    public String getLocation(){return this.location;}
}
