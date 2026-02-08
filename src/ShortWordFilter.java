public class ShortWordFilter implements IFilter{
    public boolean accept(Object x){
        if(x instanceof String){
            return ((String)x).length()<5;
        }
        else return false;
    }
}
