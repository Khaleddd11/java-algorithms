class ExceptionThrower {
    
    public void method1() throws MyException {
        System.out.println("Method 1 is executing...");
        throw new MyException("Exception thrown from Method 1");
    }
    
    public void method2() throws MyException {
        System.out.println("Method 2 is executing...");
        throw new MyException("Exception thrown from Method 2");
    }
    
    public void method3() throws MyException {
        System.out.println("Method 3 is executing...");
        throw new MyException("Exception thrown from Method 3");
    }
}