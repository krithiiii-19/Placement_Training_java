import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static boolean breaks(String w,List<String>dit) {
        Set<String> dict=new HashSet<>();
        int size=w.length();
        boolean[] dp=new boolean[size+1];
        dp[0]=true;
        for(int ind=1;ind<=size;ind++){
            for(int j=0;j<ind;j++){
                String sub=w.substring(j,ind);
                if(dp[j]&&dict.contains(sub)){
                    dp[ind]=true;
                    break;
                }
            }
        }
        return dp[size];
    }
    public static void main(String[] args) {
        String src="applepenapple";
        List<String>dict=Arrays.asList("apple","pen");
        System.out.println(breaks(src,dict));
    }
}
