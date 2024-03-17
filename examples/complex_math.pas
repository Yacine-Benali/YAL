// https://www.programiz.com/java-programming/online-compiler/
// python
program complexMath
var
result1:real;
result2:bool;
begin
    // Combining Basic Operations
    result1 := ((12.5 + 23.5) * 3 - 4.5) / (2.75 * (6 - 1.5)) + (3.14 * 2 - 1);
    print(result1);
    // Nested Parentheses and Mixed Operations
    result1 := (10 - (3 * (2 + 1) - 4 / (1.5 + 0.5))) * ((4.2 * 3.1) / (2 + 3.5));
    print(result1);
    // Complex Fractional Operations
    result1 := ((45.75 / 7.25 + 3.5) - (18.5 * 2.1)) / ((9.75 - 4.5) * 3.25);
    print(result1);

    // Combining AND, OR, and NOT
    result2 := (true && false) || (true && !false) || !(true || false);
    print(result2);
    // Nested Logical Operations
    result2 := ((true || false) && !(false && true)) || (false && (!true || true));
    print(result2);
    // Mixing Multiple Logical Operators
    result2 := !((true && false) || (false || !true)) && (true || !(false && true));
    print(result2);
    // Deeply Nested Boolean Expressions
    result2 := ((true && (false || true)) || !(true && (false || (true && false)))) && !(false || true);
    print(result2);
end