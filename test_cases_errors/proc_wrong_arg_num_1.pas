program procWrongArgNum

procedure showResult(x:int, y:int)
begin
    print(x + y);
end

var
    a:int;
    b:int;

begin
    a:=1; b:=2;
    showResult(a);
    print(a+b);
end