program funcArgNotInit

function showResult(x:int, y:int): int
begin
    Result := x + y;
end

var
    a:int;
    b:int;
    c:int;

begin
    a:=1;
    c:=showResult(a,b);
    print(c);
end