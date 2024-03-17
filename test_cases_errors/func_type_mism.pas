program funcTypeMism

function showResult(x:int, y:int): int
begin
    Result := x + y;
end

var
    a:real;
    b:real;
    c:real;

begin
    a:=1.25; b:=2.75;
    c:=showResult(a,b);
    print(c);
end