public class ContainerWater {
    public static int containerCapacity(int[] nums){
        int l=0;
        int r=nums.length-1;
        int max=0;
        int area=0;
        while(l<r){
            int height=Math.min(nums[l],nums[r]);
            area=height*(r-l);
            if(nums[l]>nums[r])
                r--;
            else l++;
            max=Math.max(max,area);
        }
        return max;
        
    }
    public static void main(String[] args) {
        int[] nums={1,8,6,2,5,4,8,3,7};
        int[] height={1,1};
        System.out.println(containerCapacity(nums));
        System.out.println(containerCapacity(height));
    }
}
    

