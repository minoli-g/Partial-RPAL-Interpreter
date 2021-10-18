# Partial-RPAL-Interpreter

This is a partial interpreter for the RPAL functional language. It takes the Abstract Syntax Tree of an RPAL program and generates the program's output by standardizing the AST and evaluating the resulting control stack.

## Running the interpreter
In a terminal window at the root of the repo, run ```make```. This compiles the Java source code. 

(Make is a Unix utility that ... . You can get Make for Windows [here](http://gnuwin32.sourceforge.net/packages/make.htm))

Then, run 
``` 
java myrpal ast-samples/ast.txt
```
