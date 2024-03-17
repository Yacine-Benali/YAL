program funcNotRet

function showResult(w:int, y:int): int
var
    z:int;
begin
    z := w + y;
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