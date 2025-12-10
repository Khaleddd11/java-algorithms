// Generic class for Complex Numbers
//number is absatrct class for all  numeric wrapper classes
class ComplexNumber<T extends Number> {
    private T real;
    private T imaginary;
    
    // Constructor
    public ComplexNumber(T real, T imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    // Getters
    public T getReal() {
        return real;
    }
    
    public T getImaginary() {
        return imaginary;
    }
    
    // Addition
    public ComplexNumber<Double> add(ComplexNumber<T> other) {
        double newReal = this.real.doubleValue() + other.real.doubleValue();
        double newImaginary = this.imaginary.doubleValue() + other.imaginary.doubleValue();
        return new ComplexNumber<>(newReal, newImaginary);
    }
    
    // Subtraction
    public ComplexNumber<Double> subtract(ComplexNumber<T> other) {
        double newReal = this.real.doubleValue() - other.real.doubleValue();
        double newImaginary = this.imaginary.doubleValue() - other.imaginary.doubleValue();
        return new ComplexNumber<>(newReal, newImaginary);
    }
    
    // Multiplication
    public ComplexNumber<Double> multiply(ComplexNumber<T> other) {
        // (a + bi) * (c + di) = (ac - bd) + (ad + bc)i
        double newReal = this.real.doubleValue() * other.real.doubleValue() - 
                        this.imaginary.doubleValue() * other.imaginary.doubleValue();
        double newImaginary = this.real.doubleValue() * other.imaginary.doubleValue() + 
                             this.imaginary.doubleValue() * other.real.doubleValue();
        return new ComplexNumber<>(newReal, newImaginary);
    }
    

    
    // Display method
    public void display() {
        if (imaginary.doubleValue() >= 0) {
            System.out.println(real + " + " + imaginary + "i");
        } else {
            System.out.println(real + " - " + Math.abs(imaginary.doubleValue()) + "i");
        }
    }
}

