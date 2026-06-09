import java.util.Arrays;

class Warehouse<T>{
    private T[] data;
    public void setData(T[] data){
        this.data=data;
    }
    public T[] getData(){
        return data;
    }
}
public class DemoGenerics{
    public static void main(String[] args) {
        Warehouse<Integer>house1=new Warehouse<Integer>();
        house1.setData(new Integer[]{1,2,3,4,5});
        Warehouse<String>house2=new Warehouse<String>();
        house2.setData(new String[]{"cognizant","wipro","Infosys"});
        System.out.println(Arrays.toString(house2.getData()));
        System.out.println(Arrays.toString(house1.getData()));
    
    }

}
