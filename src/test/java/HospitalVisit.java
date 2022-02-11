import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Builder
public class HospitalVisit {
    public String hospitalname;
    public String hospitallocation;
    private final List<LocalDate> date;

    public HospitalVisit(String hospitalname, String hospitallocation, List<LocalDate> dates) {
        this.hospitalname = hospitalname;
        this.hospitallocation = hospitallocation;
        this.date = dates;
    }

    public void addVisitDetails(LocalDate date) {
        this.date.add(date);
    }

    public List<LocalDate> getDates() {
        return this.date;
    }

    public int getTotalVisit() {
        return this.date.size();
    }

    public long getlastNodaysVisit(int days) {
        LocalDate date = LocalDate.now();
        LocalDate past = date.minusDays(days);
        long location_count = this.date.stream().filter((s) -> s.isAfter(past) || s.compareTo(date) == 0).count();
        return location_count;
    }

    public long getVisitDuringATimeRange(LocalDate date1, LocalDate date2) {
        long totalVisit = this.date.stream().filter((s) -> s.isAfter(date1) && s.isBefore(date2)).count();
        return totalVisit;
    }

}
