import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BigRectLister {
    ArrayList<Rectangle> rects = new ArrayList<>();
    BigRectangleFilter filter = new BigRectangleFilter();
    void main(String[] args){
        MakeRectangles();
        PrintRects();

    }
    void MakeRectangles(){
        System.out.println("Making randomized rectangles");
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Rectangle r = new Rectangle(10,
                    10,
                    random.nextInt(6) + 1,
                    random.nextInt(6) + 1
            );//get a randomly sized rectangle
            rects.add(r);
        }//saves me time and also lets me truly test the filter
    }
    void PrintRects(){
        System.out.println("Here are the rectangles:");
        for(Rectangle r: rects){
            System.out.println("------------------------------");
            System.out.print(r);
            if(filter.accept(r)){
                System.out.print(" This is a big one!");
            }
            System.out.println();
            System.out.println("Perimeter: " + (r.height + r.width)*2);
        }
    }
}
