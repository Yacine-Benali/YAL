program typeMism

function showResult(x:int, y:int): int
begin
    Result := x + y;
end

var
    a:int;
    b:int;
    c:real;

begin
    a:=1; b:=2;
    c:=showResult(a,b);
    print(c);
end