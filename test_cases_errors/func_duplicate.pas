program funcDupe

function showResult(x:int, y:int): int
begin
    Result := x + y;
end

function showResult(a:int, b:int): int
begin
    Result := a + b;
end

var
    a:int;
    b:int;
    c:int;

begin
    a:=1; b:=2;
    c:=showResult(a,b);
    print(c);
end