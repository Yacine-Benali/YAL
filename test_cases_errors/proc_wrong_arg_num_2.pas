program procWrongArgNum

procedure showResult(x:int)
begin
    print(x);
end

var
    a:int;
    b:int;

begin
    a:=1; b:=2;
    showResult(a,b);
    print(a+b);
end