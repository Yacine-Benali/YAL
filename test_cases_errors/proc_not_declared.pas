program procNotDeclared

procedure showResult(x:int, y:int)
begin
    print(x + y);
end

var
    a:int;
    b:int;

begin
    a:=1; b:=2;
    showAnswer(a,b);
    print(a+b);
end