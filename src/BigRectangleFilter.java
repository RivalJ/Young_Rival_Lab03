import java.awt.*;

public class BigRectangleFilter implements IFilter{
    @Override
    public boolean accept(Object x) {
        if(x instanceof Rectangle){
            double perimeter;
            perimeter = (((Rectangle)x).getWidth()+((Rectangle)x).getHeight())*2;
            return perimeter>10;
        }
        else return false;
    }
}
