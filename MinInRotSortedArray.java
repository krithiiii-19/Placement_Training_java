public class MinInRotSortedArray {
    public static void main(String[] args) {
        int[] arr={10,5,6,3,1,0};
        int left=0,right=arr.length-1;
        while(left<right) {
            int mid=left+(right-left)/2;
            if(arr[mid]>arr[right]) left=mid+1;
            else right=mid;
        }
        System.out.println(arr[left]);
    }
}