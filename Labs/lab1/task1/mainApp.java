public class mainApp {
    public static void main (String [] args ){
         int [] numbers =  new int [1000];
         
         for ( int i =0 ; i< numbers.length; i++){
            numbers [i]= (int)(Math.random()*10000);
         }
 MinMaxExtractor extractor = new MinMaxExtractor();

  long start = System.nanoTime();

  extractor.process(numbers);

  long end = System.nanoTime();

 long timeTaken = end - start;

 // 7. Print results
        System.out.println("Min = " + extractor.min);
        System.out.println("Max = " + extractor.max);
        System.out.println("Time taken (ns): " + timeTaken);
        
             }
}