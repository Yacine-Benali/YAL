// Lexical errors prevent the source code from being correctly tokenized, making it impossible 
// for the next phases of compilation (syntax analysis, semantic analysis, etc.) to proceed. 
// They are usually detected by the compiler or interpreters lexer (or scanner) and must be corrected 
// for the program to compile or run successfully.
program Lexical
var
    @number:int; // invalid character
    name:string;
begin 
    name:="Hello World; // String or Character Literal Errors Missing closing quote
    number:= 123abc // malformed numbers
    // Comments Errors
    /* This is a comment
    System.out.println("Hello"); // This line becomes part of the comment       

end