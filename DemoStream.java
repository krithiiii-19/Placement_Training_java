import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoStream {
    public static void main(String[] args) {
        List<Double> bmi = Arrays.asList(21.5, 18.6, 31.7, 29.6, 15.8, 23.4);
        
        List<Double> underweight = bmi.stream()
            .filter(each -> each <= 18.5)
            .collect(Collectors.toList());
            
        System.out.println(underweight);
        
        bmi.stream()
            .filter(each -> each >= 25)
            .forEach(System.out::println);
    }
}