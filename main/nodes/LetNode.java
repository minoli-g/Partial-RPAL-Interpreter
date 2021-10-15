package nodes;

public class LetNode extends Node {
	
	public LetNode(int depth){
	}
	
	@Override
	public Node getReplacement() { return new GammaNode(); }
	
	@Override
	public void attachStandardizedChildren(Node replacement) {}
	
}