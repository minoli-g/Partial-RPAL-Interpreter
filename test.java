import main.nodes.NodeFactory;
import main.nodes.Node;

public class Test {
    public static void main (String[] args) {
        Node a = NodeFactory.createNode("let",2);
        System.out.println(Integer.toString(a.getNodeDepth()));
    }
}