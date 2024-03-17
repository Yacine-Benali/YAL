program dupeVar

function showResult(x:int, y:int): int

var
    a:string;

begin
    Result := x + y;
end

var
    a:int;
    b:int;
    c:int;

    b:string;

begin
    a:=1; b:=2;
    c:=showResult(a,b);
    print(c);
end