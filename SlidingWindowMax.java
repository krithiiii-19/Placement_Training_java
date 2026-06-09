import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {
    public static int[] traverse(int[] arr,int win) {
        if(arr.length==0)return new int[0];
        int size=arr.length,index=0;
        int[] res=new int[size-win+1];
        Deque<Integer>dq=new LinkedList<>();
        while(index<size){
            while(!dq.isEmpty()&&dq.peekFirst()<=Index-win)
                dq.pollFirst();
            while (condition) {
                
            }
        }
    }
}
