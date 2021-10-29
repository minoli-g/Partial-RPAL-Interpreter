package main.csemachine;

import main.nodes.Node;

import java.util.ArrayList;

public class ControlStructureGroup {

    private ArrayList<ControlStructure> group;
    private int lastAddedIndex;

    public ControlStructureGroup(){
        this.group = new ArrayList<ControlStructure>();
        this.lastAddedIndex = -1;
    }

    public int createControlStructure(Node n) {

        ControlStructure cs = new ControlStructure();
        group.add(cs);
        addToControlStructure(cs, n);

        lastAddedIndex++;
        return lastAddedIndex;

    }

    public void addToControlStructure(ControlStructure cs, Node n) {

        switch (n.getType()) {

            case "->":
                //add the two deltas and beta
                int thenDelta = createControlStructure(n.getChildAt(1));  //delta-then structure
                int elseDelta = createControlStructure(n.getChildAt(2));  //delta-else

                cs.addElement(new DeltaElement(thenDelta));
                cs.addElement(new DeltaElement(elseDelta));

                cs.addElement(new ControlElement("beta"));

                //add the condition being evaluated to CS
                addToControlStructure(cs, n.getChildAt(0));

                break;

            case "tau":
                //add the tau with number of children
                cs.addElement(new TauElement(n.numberOfChildren()));

                //add all children to CS
                for (Node child: n.getChildren()){
                    addToControlStructure(cs, child);
                }
                break;

            case "lambda":
                //add the lambda expression with index and bindings
                ArrayList<Node> identifiers = n.getChildAt(0).getChildren();
                ArrayList<String> bindings = new ArrayList<String>();

                for (Node idNode: identifiers){
                    //ControlElement ce = new ControlElement(idNode.getType());
                    //bindings.add(ce.getIdName);

                    bindings.add(idNode.getType());
                }

                //create new CS with Lambda's right child.
                int newLambda = createControlStructure(n.getChildAt(1));

                //create new Lamba Element
                cs.addElement(new LambdaElement(bindings,newLambda));

                break;

            default:
                cs.addElement(new ControlElement(n.getType()));

                //add all children to CS
                for (Node child: n.getChildren()){
                    addToControlStructure(cs, child);
                }
                break;
                
        }
    }

    public ControlStructure getControlStructureAt(int index){
        return group.get(index);
    }

    public void display(){
        for (ControlStructure cs: group){
            
            for (ControlElement ce: cs.getControlElements()){
                System.out.println(ce.getType());
            }

            System.out.println("***");
        }
    }

}