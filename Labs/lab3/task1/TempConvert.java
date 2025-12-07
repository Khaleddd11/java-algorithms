import java.util.function.Function;
public class TempConvert implements Function<Double,Double>{

    public Double apply (Double celsius){
        return (celsius * 9/5) +32;
    }
}