import java.util.ArrayList;

class check {
    private int n;

    public check(int b){
        n = b;
    }

    public static check createCheckFromInt(int g) {
        this.n = g;
        return this;
    }

    public int getn(){ return n; }
}

public class test {


    public static void main (String[] args) {
        check c = check.createCheckFromInt(90);
        System.out.println(Integer.toString(c.getn()));
    }


}