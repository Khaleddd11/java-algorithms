import java.util.ArrayList;
class ShapeTest {
    
    // Generic method that accepts only child classes of Shape
    public static <T extends Shape> void drawShapes(ArrayList<T> shapes) {
        System.out.println("Drawing all shapes:");
        for (T shape : shapes) {
            shape.draw();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Create ArrayList of Rectangles
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle());
        rectangles.add(new Rectangle());
        rectangles.add(new Rectangle());
        
        // Create ArrayList of Circles
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle());
        circles.add(new Circle());
        
        // Test the generic method
        System.out.println("Testing with Rectangles:");
        drawShapes(rectangles);
        
        System.out.println("Testing with Circles:");
        drawShapes(circles);
    }
}