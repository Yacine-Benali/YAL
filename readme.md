- [[#How to use|How to use]]
- [[#Basic Introduction to YAL|Basic Introduction to YAL]]
	- [[#Basic Introduction to YAL#Overall Structure|Overall Structure]]
	- [[#Basic Introduction to YAL#Variables and Their Types|Variables and Their Types]]
	- [[#Basic Introduction to YAL#Functions and Function Returns Using `Result` Variable|Functions and Function Returns Using `Result` Variable]]
	- [[#Basic Introduction to YAL#Procedures|Procedures]]
		- [[#Procedures#Calling a Procedure|Calling a Procedure]]
	- [[#Basic Introduction to YAL#If Statement|If Statement]]
	- [[#Basic Introduction to YAL#While Statement|While Statement]]
- [[#Semantic Analysis|Semantic Analysis]]
- [[#Limitations|Limitations]]

## How to use
1. Clone the repo
2. Have ``javacc`` ``jjtree`` and optionally `dot` installed
3. use the PowerShell script `build.ps1` to build the compiler it will generate ``yalc.jar`` file
4. run the compiler on your code using `java -jar yalc.jar yourfile.txt`
## Basic Introduction to YAL

This README provides a very basic introduction to YAL programming language, covering some fundamental concepts such as variables, functions, if statements, and while loops.
### Overall Structure
```
program programName
// function declaration first (this is enforced)
// procedure declartion 
var
// variables declaration 
begin 
	// statements
end
```

### Variables and Their Types

In YAL, a variable must be declared before it can be used in the variables declaration section. Each variable has a specific type, which determines the size and layout of the variable's memory, as well as the range of values that can be stored within that memory.

```
var     
number: int;     
name: string;     
isAvailable: boolean;     
price: real;
```

Here, `number` is an integer variable, `name` is a string, `isAvailable` is a boolean, and `price` is a real (floating-point) variable.

### Functions and Function Returns Using `Result` Variable

Functions in YAL are blocks of code that carry out specific tasks and can return a value. The `Result` variable is used in functions to hold the value that the function will return. functions have there own variables declaration sections


```
function AddNumbers(a:integer, b: integer): integer 
// optional variables declaration section
// var
// x:int;
begin     
Result := a + b; 
end
```

This function, `AddNumbers`, takes two integers `a` and `b`, adds them, and returns the result.
### Procedures

Procedures in YAL are blocks of code that are designed to perform a specific task, but unlike functions, they do not return a value. Procedures are useful for executing code that performs actions, such as printing to the screen, calculating results, or modifying variables, without needing to return a result.

Here's a simple example of a procedure:

```
procedure DisplayGreeting(name: String)
begin     
	print("hello, " + name); 
end
```

In this example, the `DisplayGreeting` procedure takes a single parameter, `name`, and prints a personalized greeting message.

#### Calling a Procedure

To use a procedure, you simply call it by its name followed by parentheses. If the procedure takes parameters, you provide the values within the parentheses.

```
begin     
DisplayGreeting('Alice'); 
end
```
### If Statement

The `if` statement is used for conditional execution. YAL executes the code inside the `if` statement only if the condition is true.

```
var     
age: int; 
begin     
	age := 20;     
	if age >= 18 then     
	begin         
		print('You are an adult.');     
	end
	else
	begin
		// something else 
	end
end
```

This will output "You are an adult." because age is greater than or equal to 18.
### While Statement

The `while` statement allows you to repeat a block of code as long as a certain condition is true.

```
var     
count: int; 
begin     
	count := 1;     
	while count <= 5 do     
	begin         
		print('Count: ', count);
		count := count + 1;
	end
end
```

This will print the numbers from 1 to 5.
### Arithmetic and boolean expression*
## Built-in functions
### print
same as ``System.out.prinln`` in java
## readInt
this function will keep asking the user to input an int until an int is received 
## readString
receives a string from the user on fail it returns null

## Semantic Analysis
We detect most semantic errors, either inside nested operations, like ifs and whiles, or outside them.. For displaying these errors we indicate the line, variable and type of error. Errors we detect range from:
1. **Function-related Errors:**
    -  [x] Duplicate functions: Declaring functions with the same name.
    -  [x] Duplicate identifier: Declaring functions with the same name as another identifier such as a function name, variable name or procedure name
    -  [x] Function type mismatch: Mismatch between declared and actual types in function definitions.
    -  [x] Function no return: function does not return anything when it should: this will return null
    -  [x] Function not declared: Calling a function that hasn't been declared.
    -  [x] Wrong number of arguments for a function: Incorrect number of parameters passed to a function.
    -  [x] Wrong type of arguments: Mismatch in the type of arguments passed to a function.
    -  [x] Return type not declared: Missing declaration of the return type for a function.
    -  [x] Return type mismatch: Mismatch between the declared and actual return types of a function.
    -  [x] Argument not initialized: giving a function a variable that has not been initialized
1. . **Procedure-related Errors:**
    -  [x] Duplicate procedure: Declaring procedure with the same name.
    -  [x] Duplicate identifier: Declaring functions with the same name as another identifier such as a function name, variable name or procedure name
    -  [x] procedure type mismatch: Mismatch between declared and actual types in procedure definitions.
    -  [x] procedure not declared: Calling a procedure that hasn't been declared.
    -  [x] Wrong number of arguments for a procedure: Incorrect number of parameters passed to a procedure.
    -  [x] Wrong type of arguments: Mismatch in the type of arguments passed to a procedure.
    -  [x] Argument not initialized: giving a procedure a variable that has not been initialized
1. **Argument and Parameter Errors:**
    -  [x] Undefined arguments: Use of arguments that haven't been defined.
2. **Variable-related Errors:**
    -  [x] Type mismatches: Inconsistencies between declared and assigned types of variables.
    -  [x] Duplicate variables: In the same scope, declaring variables with the same name or with a name of another identifier such as a function or a procedure .
    -  [x] Undefined variables: Using variables that haven’t been defined.
- **Expression-Related Errors:**
	-  [x] Arithmetic Type Mismatch: Performing arithmetic operations on incompatible types, except for certain cases like int and real (int gets casted to real).
	-  [x] Comparison Type Mismatch: Comparing values of different types, with exceptions for int and double.
	-  [x] Invalid Boolean Operations: Using logical boolean operators (like AND, OR) on non-boolean types.
	-  [x] Division by Zero: Attempting to divide a number by zero, which is undefined.

## Limitations 
- Can not call a function within an expression 
- **Variable Types:**
    Supported variable types are: integer (int), real number (real), string (string), and boolean (boolean).
    no null type, null is not recognized.
- **Variable Declaration:**
    Declaration of multiple variables in a single line using comma separation is not allowed. 
    This simplification helps in the implementation of the Abstract Syntax Tree (AST) for variable declarations.
- **Function Calls in Parameters:**
    When calling a function, only values or variable names can be used as parameters. Function calls within parameters are not permitted.
- **Semantic Analysis:**
    Semantic analysis occurs at runtime. Therefore, functions with semantic errors can be declared without immediate detection. These errors become apparent only when the function is called. This could be improved by implementing separate visitors for semantic analysis and code generation.
- **Nested Functions and Procedures:**
    Nested functions and procedures are not allowed.
- **Function Calls in Expressions:**
    Functions cannot be called within arithmetic expressions