program funcWrongArgNum

function showResult(x:int, y:int): int
begin
    Result := x + y;
end

var
    a:int;
    b:int;
    c:int;

begin
    a:=1; b:=2;
    c:=showResult(a);
    print(c);
end