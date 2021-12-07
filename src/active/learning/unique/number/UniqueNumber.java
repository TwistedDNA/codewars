package active.learning.unique.number;

public class UniqueNumber {
    public static double findUniq(double arr[]) {
        double a = arr[0];
        double b = 0.0d;
        boolean bIsSet = false;
        for(double elem:arr){
            if(bIsSet){
                if(elem == a){
                    return b;
                } else return a;
            }
            if(elem != a){
                b = elem;
                bIsSet = true;
            }
        }
        return b;
    }
}
