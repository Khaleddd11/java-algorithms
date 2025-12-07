import java.util.function.Function;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Create functional interface instance
        Function<Double[], Double[]> solver = new Root();

        // Define coefficients: a, b, c
        Double[] coefficients1 = {1.0, -3.0, 2.0}; // x^2 - 3x + 2 = 0
        Double[] coefficients2 = {1.0, 2.0, 5.0};  // x^2 + 2x + 5 = 0 (no real roots)

        // Solve quadratic equations
        Double[] roots1 = solver.apply(coefficients1);
        Double[] roots2 = solver.apply(coefficients2);

        // Print results
        if (roots1.length > 0) {
            System.out.println("Roots of equation 1: " + Arrays.toString(roots1));
        } else {
            System.out.println("Equation 1 has no real roots.");
        }

        if (roots2.length > 0) {
            System.out.println("Roots of equation 2: " + Arrays.toString(roots2));
        } else {
            System.out.println("Equation 2 has no real roots.");
        }
    }
}
