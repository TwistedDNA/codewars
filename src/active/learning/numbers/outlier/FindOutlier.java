package active.learning.numbers.outlier;

public class FindOutlier {

    static int find(int[] integers) {
     boolean returnFirstOdd = false;
     boolean returnFirstEven = false;
        if(isEven(integers[0]) && isEven(integers[1])){
            returnFirstOdd = true;
        }else if(isOdd(integers[0]) && isOdd(integers[1])){
            returnFirstEven = true;
        } else if(isEven(integers[2])){
            returnFirstOdd = true;
        } else {
            returnFirstEven = true;
        }
        for (int e:integers){
            if(returnFirstEven && isEven(e) || returnFirstOdd && isOdd(e)){
                return e;
            }
        }
        return 0;
    }
    private static boolean isEven(int e){
        return Math.abs(e) % 2 == 0;
    }
    private static boolean isOdd(int e){
        return !isEven(e);
    }
}
