import java.util.function.Function; 

public class Main {
    public static void main(String[]args){
        Function<Double,Double> converter = new TempConvert();

        
        double temp1 = 0.0;
        double temp2 = 25.0;
        double temp3 = 100.0;

        System.out.println(temp1 + "°C = " + converter.apply(temp1) + "°F");
        System.out.println(temp2 + "°C = " + converter.apply(temp2) + "°F");
        System.out.println(temp3 + "°C = " + converter.apply(temp3) + "°F");

    }
}