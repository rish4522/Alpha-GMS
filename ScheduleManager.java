import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ScheduleManager {
    private static ArrayList<Schedule> schedules = new ArrayList<>();

    public static void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }

    public static ArrayList<Schedule> getTrainerSchedule(String trainerName) throws ScheduleException {
        ArrayList<Schedule> trainerSchedules = new ArrayList<>();
        for (Schedule schedule : schedules) {
            if (schedule.getTrainer().equals(trainerName)) {
                trainerSchedules.add(schedule);
            }
        }
        if (trainerSchedules.isEmpty()) {
            throw new ScheduleException("No schedules found for trainer " + trainerName);
        }
        return trainerSchedules;
    }

    public static ArrayList<Schedule> getClientSchedule(String clientName) throws ScheduleException {
        ArrayList<Schedule> clientSchedules = new ArrayList<>();
        for (Schedule schedule : schedules) {
            if (schedule.getClient().equals(clientName)) {
                clientSchedules.add(schedule);
            }
        }
        if (clientSchedules.isEmpty()) {
            throw new ScheduleException("No schedules found for client " + clientName);
        }
        return clientSchedules;
    }

    public static void loadSchedules() {
        // Load schedules from a database or file, etc.
        // For the purpose of this example, we'll add some schedules manually
        schedules.add(new Schedule(LocalDate.of(2022, 10, 1), LocalTime.of(10, 0), LocalTime.of(11, 0), "Yoga", "John Doe", "Jane Smith"));
        schedules.add(new Schedule(LocalDate.of(2022, 10, 2), LocalTime.of(15, 0), LocalTime.of(16, 0), "Pilates", "Mary Johnson", "John Smith"));
        schedules.add(new Schedule(LocalDate.of(2022, 10, 3), LocalTime.of(9, 0), LocalTime.of(10, 0), "CrossFit", "John Doe", "John Smith"));
    }
}
