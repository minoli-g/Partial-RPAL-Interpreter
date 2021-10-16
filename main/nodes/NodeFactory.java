package main.nodes;

import main.nodes.*;

public class NodeFactory {

    private static String[] acceptedTypes = {
        "gamma", "->","tau",",","Y",
        "or", "&", "not", "gr", "ge", "ls", "le", "eq", "ne",  //boolean operators
        "+", "-", "neg", "*", "/", "**"                        //arithmetic operators
    };

    private static boolean isAccepted(String type) {
        for (String s: acceptedTypes) {
            if (type.equals(s)) { return true; }
        }
        return false;
    }

    public static Node createNode(String type, int depth) {

        if (isAccepted(type)) { return new AcceptedNode(type, depth); }
        
        switch(type) {

            case "let": return new LetNode(depth);
            case "where": return new WhereNode(depth);
            case "within": return new WithinNode(depth);
            case "rec": return new RecNode(depth);
            case "fcn_form": return new FcnFormNode(depth);
            case "and": return new AndNode(depth);
            case "@": return new InfixNode(depth);
            //case "lambda": return new LambdaNode(depth);
        }
        return new AcceptedNode(type,depth);
    }
}