class Main {
    
    public static void main(String[] args) {
        ExceptionThrower thrower = new ExceptionThrower();
        
        // Calling method1 with try-catch-finally
        try {
            thrower.method1();
        } catch (MyException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block for method1\n");
        }
        
        // Calling method2 with try-catch-finally
        try {
            thrower.method2();
        } catch (MyException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block for method2\n");
        }
        
        // Calling method3 with try-catch-finally
        try {
            thrower.method3();
        } catch (MyException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block for method3\n");
        }
    }
}