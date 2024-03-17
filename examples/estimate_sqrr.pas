// This a YAL program that calculates the approximate square root of a given number using
// the Newton-Raphson method. It starts with an initial guess and iteratively refines 
// it until the approximation is within a specified tolerance level (epsilon). The 
// main method demonstrates this calculation with an example number.
// no built-in abs function implemented our own


program SqaureRoot

function abs(number:real):real
begin
    if number < 0 then
    begin
        Result := -number;
    end
    else
    begin
        Result := number;
    end
end

function approximateSquareRoot(number:real , epsilon:real ):real
var
    guess:real;
    accuracy:real;
begin
    guess := number / 2.0;
    accuracy := abs(guess * guess - number);
    while accuracy > epsilon do
    begin
        guess := (guess + number / guess) / 2.0;
        accuracy := abs(guess * guess - number);
    end
    Result:= guess;

end

var
    number:real;
    accuracy:real;
    result:real;
begin
    number := 2.0;
    accuracy:=0.0000001;
    result := approximateSquareRoot(number,accuracy);
    print("Estimated SqaureRoot: " + result);
end