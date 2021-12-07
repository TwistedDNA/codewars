package active.learning.sort.odd;

public class SortOdd {
    public static int[] sortArray(int[] array) {
        for(int i=0;i<array.length;i++){
            if(array[i] % 2 == 0){
                continue;
            }
            for(int j = array.length-1; j>i;j--){
                if(array[j] % 2 == 0){
                    continue;
                }
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
