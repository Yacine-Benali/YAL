// Estimating π using Leibniz Formula
// The Leibniz formula sums an infinite series:
// π = 4 * (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 + ...)
// calling function isPair within the function estimatePi
// no built-in % function so I implemented my own

program EstimatePi

function isPair(i:int):bool
begin
    Result:=(i - (i / 2) * 2) == 0;
end

function estimatePi(terms:int):real
var
    i:int;
    pi:real;
    ispair:bool;
begin
    i:=0;
    pi:=0.0;
    while i < terms do
    begin
        // complex op calling a function within a function
        ispair:=isPair(i);
        if ispair then
            begin
                pi := pi + 1.0 / (2 * i + 1);
            end
        else 
            begin
                pi := pi - 1.0 / (2 * i + 1);
            end
        i := i+1;
        print( "pi:" +pi);

    end
    Result:= 4 * pi;
end

var
    terms:int;
    pi:real;
begin
    terms:= 1000;
    pi := estimatePi(terms);
    print("Estimated Pi: " + pi);
end