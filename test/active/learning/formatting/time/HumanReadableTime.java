package active.learning.formatting.time;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int hours = seconds / 3600;
        seconds = seconds % 3600;
        int minutes = seconds / 60;
        seconds = seconds % 60;
        String humanReadableTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        System.out.println(humanReadableTime);
        return humanReadableTime;
    }
}
