import java.util.Date;

public class Schedule {
    private Date date;
    private int startTime;
    private int endTime;

    public Schedule(Date date, int startTime, int endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Date getDate() {
        return date;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}
