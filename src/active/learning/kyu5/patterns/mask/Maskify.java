package active.learning.kyu5.patterns.mask;

public class Maskify {
    public static String maskify(String str) {
        if (str.length() <= 4) {
            return str;
        }
        String lastFour = String.copyValueOf(str.toCharArray(), str.length() - 4, 4);
        String grid = new String(new char[str.length() - 4]).replace('\0', '#');
        return grid + lastFour;
    }
}
