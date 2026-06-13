public class GasStation {
    public static int circle(int[] gas,int[] cost) {
        int tTank=0,cTank=0,sStation=0;
        for(int index=0;index<gas.length;index++){
            tTank +=gas[index]-cost[index];
            cTank +=gas[index]-cost[index];
            if(cTank<0){
                sStation=index+1;cTank=0;}
            }
            if(cTank>=0) return sStation;
            else return -1;
        }
        public static void main(String[] args){
            int[] gas={1,2,3,4,5};
            int[] cost={3,4,5,1,2};
            System.out.println(circle(gas, cost));
        }
    }


