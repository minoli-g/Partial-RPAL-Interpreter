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
	main/csemachine/machine.java \
	main/csemachine/Environment.java \
	main/csemachine/ControlElement.java \
	main/csemachine/ControlStructure.java \
	main/csemachine/ControlStructureGroup.java \
	main/csemachine/DeltaElement.java \
	main/csemachine/LambdaElement.java \
	main/csemachine/TauElement.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class