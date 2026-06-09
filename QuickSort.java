import java.util.Arrays;

public class QuickSort {
    public static int findPivot(int[] arr,int start,int end){
        int init=start-1,pData=arr[end];
        for(int trv=start;trv<end;trv++){
            if(arr[trv]<pData){
                init++;
                int temp=arr[init];
                arr[init]=arr[trv];
                arr[trv]=temp;
            }
        }
        int temp=arr[init+1];
            arr[init+1]=arr[end];
            arr[end]=temp;
            return init+1;
    }
        public static void split(int[] arr,int start,int end){
            if(start<end){
                int pIndex=findPivot(arr, start, end);
                split(arr,start,pIndex-1);
                split(arr,pIndex+1,end);
            }
        }
        public static void main(String[] args) {
            int[] a={4,2,7,13,45};
            split(a,0,a.length-1);
            System.out.println(Arrays.toString(a));
        }
    }
