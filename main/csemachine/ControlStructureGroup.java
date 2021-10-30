package main.csemachine;

import main.csemachine.elements.*;

import main.nodes.Node;

import java.util.ArrayList;

public class ControlStructureGroup {

    private ArrayList<ControlStructure> group;
    private int lastAddedIndex;

    public ControlStructureGroup(){
        this.group = new ArrayList<ControlStructure>();
        this.lastAddedIndex = -1;
    }

    public int createControlStructure(Node n) throws Exception {

        ControlStructure cs = new ControlStructure();
        group.add(cs);
        addToControlStructure(cs, n);

        lastAddedIndex++;
        return lastAddedIndex;

    }

    public void addToControlStructure(ControlStructure cs, Node n) throws Exception {

        switch (n.getType()) {

            case "->":
                //add the two deltas and beta
                int thenDelta = createControlStructure(n.getChildAt(1));  //delta-then structure
                int elseDelta = createControlStructure(n.getChildAt(2));  //delta-else

                cs.addElement(new DeltaElement(thenDelta));
                cs.addElement(new DeltaElement(elseDelta));

                cs.addElement(new BetaElement());

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
                ArrayList<String> bindings = new ArrayList<String>();

                if(n.getChildAt(0).getType()==",") {
                    ArrayList<Node> identifiers = n.getChildAt(0).getChildren();

                    for (Node idNode: identifiers){
                        ControlElement ce = ControlElementFactory.createElement(idNode);
                        bindings.add(ce.getIdName());

                        //bindings.add(idNode.getType());
                    }
                }
                else {
                    //bindings.add(n.getChildAt(0).getType());

                    ControlElement ce = ControlElementFactory.createElement(n.getChildAt(0));
                    bindings.add(ce.getIdName());
                }

                //create new CS with Lambda's right child.
                int newLambda = createControlStructure(n.getChildAt(1));

                //create new Lamba Element
                cs.addElement(new LambdaElement(bindings,newLambda));

                break;


            default: 

                cs.addElement(ControlElementFactory.createElement(n));

                for (Node child: n.getChildren()){
                    addToControlStructure(cs, child);
                }

                break;

            /* this is the part that must be handled by the factory
            case "gamma":
                cs.addElement(new GammaElement());
                break;

            default:
            //identifiers or values or unops/binops
                cs.addElement(new ControlElement(n));

                //add all children to CS
                for (Node child: n.getChildren()){
                    addToControlStructure(cs, child);
                }
                break;
                */
        }
    }

    public ControlStructure getControlStructureAt(int index){
        return group.get(index);
    }

    public void display(){
        for (ControlStructure cs: group){
            
            for (ControlElement ce: cs.getControlElements()){
                if (ce.getType()!="lambda") { System.out.println(ce.getType()); }
                else { 
                    LambdaElement le = (LambdaElement) ce;
                    System.out.println("Lambda " + le.getBindings().toString()); }
            }

            System.out.println("***");
        }
    }

}