package main.nodes;

import main.nodes.*;

public class FcnFormNode extends Node {
	
	public FcnFormNode(int depth){
		super(depth);
	}
	
	@Override
	public Node getReplacement() { return new AcceptedNode("="); }
	
	@Override
	public void attachStandardizedChildren(Node replacement) {

		Node p = this.getChildAt(0).standardizedVersion();
		Node e = this.getChildAt(this.numberOfChildren()-1).standardizedVersion(); //last child
		Node temp = replacement;

		replacement.addChild(p);

		for (int i=1; i<(this.numberOfChildren()-1); i++) {

			Node v = this.getChildAt(i).standardizedVersion();
			LambdaNode ln = new LambdaNode();

			ln.addChild(v);
			temp.addChild(ln);
			temp = ln;
			
		}

		temp.addChild(e);
		return;
	}
	
}