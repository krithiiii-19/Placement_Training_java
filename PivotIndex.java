import java.util.*;

public class  PivotIndex {
    public static void main(String[] args) {
        int a[] = {1,7,3,6,5,6};
        int preSum = 0,postSum = 0,size = a.length;
        for(int i=0;i<size;i++) {
            int[] subArray=Arrays.copyOfRange(a,i+1,size);
            postSum=Arrays.stream(subArray).sum();
            if(preSum==postSum) {
                System.out.println(i);
            }
            preSum+=a[i];
        }
    }
}
