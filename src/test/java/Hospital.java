import java.util.List;

public class Hospital {

    private String location;
    private String hospitalName;
    List<Patient>patientInside;

    public Hospital(String location,String name,List<Patient>patients){
        this.location=location;
        this.hospitalName=name;
        this.patientInside=patients;
    }
    public <patient> List<Patient> getPatientList(){return patientInside;}
    public long getLocationPatients(String location){
        long count=this.patientInside.stream().filter((s) ->s.getLocation().contains(location)).count();
        return count;
    }
    public long getPatientOutsidePune(String location){
        long count=this.patientInside.stream().filter((s)->s.getLocation().contains(location)).count();
        return patientInside.size()-count;
    }
    public double getRatioInsideToOutside(String location){
        long countInside=this.patientInside.stream().filter((s)->s.getLocation().contains(location)).count();
        long countOutside=patientInside.size()-countInside;
        return countInside/countOutside;
    }
}
