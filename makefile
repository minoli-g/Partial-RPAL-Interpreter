JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES =  \
	myrpal.java \
	main/astreader.java \
	main/nodes/Node.java \
	main/nodes/NodeFactory.java \
	main/nodes/AcceptedNode.java \
	main/nodes/AndNode.java \
	main/nodes/FcnFormNode.java \
	main/nodes/InfixNode.java \
	main/nodes/LambdaNode.java \
	main/nodes/LetNode.java \
	main/nodes/RecNode.java \
	main/nodes/WhereNode.java \
	main/nodes/WithinNode.java \
	main/csemachine/Machine.java \
	main/csemachine/Environment.java \
	main/csemachine/ControlStructure.java \
	main/csemachine/ControlStructureGroup.java \
	main/csemachine/elements/BetaElement.java \
	main/csemachine/elements/BinaryOpElement.java \
	main/csemachine/elements/ControlElement.java \
	main/csemachine/elements/ControlElementFactory.java \
	main/csemachine/elements/DeltaElement.java \
	main/csemachine/elements/GammaElement.java \
	main/csemachine/elements/IdentifierElement.java \
	main/csemachine/elements/LambdaElement.java \
	main/csemachine/elements/TauElement.java \
	main/csemachine/elements/UnaryOpElement.java \
	main/csemachine/elements/ExpElement.java
	

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class