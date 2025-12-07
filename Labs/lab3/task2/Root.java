import java.util.function.Function;

public class Root implements Function<Double[],Double[]>{
    public Double[] apply(Double [] coefficients){
        double a = coefficients[0];
        double b = coefficients[1];
        double c = coefficients[2];

        double discriminant = (b * b) - 4 * a * c;

        if(discriminant<0){
            return new Double[]{};
        }
        double sqrtDiscrimant = Math.sqrt(discriminant);

        double root1 = (-b + sqrtDiscrimant) / (2 * a);
        double root2 = (-b - sqrtDiscrimant) / (2 * a);

         return new Double[]{root1, root2};

    }
}