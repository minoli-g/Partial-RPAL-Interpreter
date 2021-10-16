package main.nodes;

import main.nodes.*;

public class LambdaNode extends Node {
	
	public LambdaNode(int depth){
		super(depth);
	}

	public LambdaNode() { super(); }

	@Override
	public String getType() { return "lambda"; }
	
	@Override
	public Node getReplacement() {return new LambdaNode(); }
	
	@Override
	public void attachStandardizedChildren(Node replacement) {

		int n = this.numberOfChildren();

		Node temp = replacement;

		if (n>2){

			for (int i=1; i<n-1; i++) {
				temp.addChild(this.getChildAt(i-1).standardizedVersion());
				LambdaNode ln = new LambdaNode();
				temp.addChild(ln);
				temp = ln;
			}
		}
		
		temp.addChild(this.getChildAt(n-2).standardizedVersion());
		temp.addChild(this.getChildAt(n-1).standardizedVersion());

		return;

	}
	
}