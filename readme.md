# How to use
1. Clone the repo
2. Have ``javacc`` ``jjtree`` and optionally `dot` installed
3. use the Powershell script `build.ps1` to build the compiler it will generate yalc.jar file
4. run the compiler on your code using `java -jar yalc.jar yourfile.txt`
# Basic Introduction to YAL

This README provides a very basic introduction to YAL programming language, covering some fundamental concepts such as variables, functions, if statements, and while loops.
### Overall Structure
```
program programName
// function declaration
// procedure declartion
var
// variables declaration 
begin 
	// statements
end
```

## Variables and Their Types

In YAL, a variable must be declared before it can be used in the variables declaration section. Each variable has a specific type, which determines the size and layout of the variable's memory, as well as the range of values that can be stored within that memory.

```
var     
number: int;     
name: string;     
isAvailable: boolean;     
price: real;
```

Here, `number` is an integer variable, `name` is a string, `isAvailable` is a boolean, and `price` is a real (floating-point) variable.

## Functions and Function Returns Using `Result` Variable

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
## Procedures

Procedures in YAL are blocks of code that are designed to perform a specific task, but unlike functions, they do not return a value. Procedures are useful for executing code that performs actions, such as printing to the screen, calculating results, or modifying variables, without needing to return a result.

Here's a simple example of a procedure:

```
procedure DisplayGreeting(name: String)
begin     
	print("hello, " + name); 
end
```

In this example, the `DisplayGreeting` procedure takes a single parameter, `name`, and prints a personalized greeting message.

### Calling a Procedure

To use a procedure, you simply call it by its name followed by parentheses. If the procedure takes parameters, you provide the values within the parentheses.

```
begin     
DisplayGreeting('Alice'); 
end
```
## If Statement

The `if` statement is used for conditional execution. YAL executes the code inside the `if` statement only if the condition is true.

```
var     
age: int; 
begin     
	age := 20;     
	if age >= 18 then     
	begin         
		writeln('You are an adult.');     
	end
end
```

This will output "You are an adult." because age is greater than or equal to 18.
## While Statement

The `while` statement allows you to repeat a block of code as long as a certain condition is true.

```
var     
count: int; 
begin     
	count := 1;     
	while count <= 5 do     
	begin         
		writeln('Count: ', count);
		count := count + 1;
	end
end
```

This will print the numbers from 1 to 5.
# Semantic Analysis
# Limitations 
