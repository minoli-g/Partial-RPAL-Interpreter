JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES =  \
	myrpal.java \
	main/astreader.java \
	main/nodes/Node.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class