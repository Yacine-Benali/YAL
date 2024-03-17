program funcNotDeclared

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
    c:=showAnswer(a,b);
    print(c);
end