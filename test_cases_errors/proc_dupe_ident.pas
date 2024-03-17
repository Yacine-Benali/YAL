program procDupeIdent

procedure showResult(x:int, y:int)
begin
    print(x + y);
end

var
    a:int;
    b:int;
    showResult:int;

begin
    a:=1; b:=2;
    showResult := a + b;
    showResult(a,b);
    print(showResult);
end