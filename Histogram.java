import java.util.Stack;

public class Histogram {
    public static int maxArea(int[] chart){
        int mArea=Integer.MIN_VALUE,temp=0;
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<=chart.length;i++){
            int cValue=(i==chart.length)?0:chart[i];
            while(!stk.isEmpty() && cValue<chart[stk.peek()]){
                int len=chart[stk.pop()];
                int brd=stk.isEmpty()?i:i-stk.peek()-1;
                temp=len*brd;
                mArea=Math.max(temp,mArea);
            }
            stk.push(i);
        }
        return mArea;
    }
    public static void main(String[] args) {
        int[] chart={2,4};
        System.out.println(maxArea(chart));
    }
}
