// Test class
class ComplexTest {
    public static void main(String[] args) {
        // Create complex numbers
        ComplexNumber<Integer> c1 = new ComplexNumber<>(3, 2);
        ComplexNumber<Integer> c2 = new ComplexNumber<>(1, 7);
        
        System.out.print("Complex Number 1: ");
        c1.display();
        
        System.out.print("Complex Number 2: ");
        c2.display();
        
        System.out.println("\n--- Arithmetic Operations ---");
        
        // Addition
        System.out.print("Addition: ");
        c1.add(c2).display();
        
        // Subtraction
        System.out.print("Subtraction: ");
        c1.subtract(c2).display();
        
        // Multiplication
        System.out.print("Multiplication: ");
        c1.multiply(c2).display();

        // Test with Double values
        System.out.println("\n--- Using Double values ---");
        ComplexNumber<Double> c3 = new ComplexNumber<>(5.5, 2.3);
        ComplexNumber<Double> c4 = new ComplexNumber<>(1.2, 3.4);
        
        System.out.print("Complex Number 3: ");
        c3.display();
        
        System.out.print("Complex Number 4: ");
        c4.display();
        
        System.out.print("Addition: ");
        c3.add(c4).display();
    }
}