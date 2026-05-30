
class BuySell {
    static void SellStock(int[] nums){
        int min=nums[0];
        int high=nums[1];
        int res=nums[1]-nums[0];
        if(nums.length<2) return;
        for (int i=0;i<nums.length;i++){
            min = Math.min(min,nums[i]);
            if(res<nums[i]-min){
                res=nums[i]-min;
                high=nums[i];
            }
        }
        System.out.println("Buy at " +min+ " Sell at " +high);
    }
    public static void main(String[] args){
        int[] a={7,1,5,3,6,4};
        int[] b={-10,-5,-2,-1,1};
        SellStock(a);
        SellStock(b);

    }
}

