import java.util.Stack;
import java.util.ListIterator;


public class test {


    public static void main (String[] args) {
        
        Stack<String> stack = new Stack<String>();

        stack.push("Bottom most");
        stack.push("Bottom middle");
        stack.push("Top middle");
        stack.push("top");

        ListIterator<String> si = stack.listIterator(stack.size());

        while (si.hasPrevious()) {
            
            String plate = si.previous();
            System.out.println(plate);

            if (plate.equals("Bottom middle")){
                break;
            }
        }
    }


}