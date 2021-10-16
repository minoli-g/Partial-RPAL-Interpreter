package main.nodes;

import main.nodes.*;

public class RecNode extends Node {
	
	public RecNode(int depth){
		super(depth);
	}
	
	@Override
	public Node getReplacement() {return new AcceptedNode("=");}
	
	@Override
	public void attachStandardizedChildren(Node replacement) {

		Node eq = this.getChildAt(0).standardizedVersion();
		Node x = eq.getChildAt(0).standardizedVersion();
		Node e = eq.getChildAt(1).standardizedVersion();

		replacement.addChild(x);

		Node gn = new AcceptedNode("gamma");
		gn.addChild(new AcceptedNode("Y"));
		
		Node ln = new LambdaNode();
		ln.addChild(x);
		ln.addChild(e);

		gn.addChild(ln);

		replacement.addChild(gn);

		return;
	}
	
}