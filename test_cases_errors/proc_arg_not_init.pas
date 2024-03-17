program procArgNotInit

procedure showResult(x:int, y:int)
begin
    Result := x + y;
end

var
    a:int;
    b:int;

begin
    a:=1;
    showResult(a,b);
    print(a+b);
end