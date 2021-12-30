package active.learning.count.ip;

public class CountIPAddresses {
    public static long ipsBetween(String start, String end) {
        String[] from = start.split("\\.");
        String[] to = end.split("\\.");
        int result = 0;
        for (int power = 0; power < 4; power++) {
            int pow = (int) Math.pow(256, power);
            result += pow * (Integer.parseInt(to[3 - power]) - Integer.parseInt(from[3 - power]));
        }
        return result;
    }
}
