program test

function square(a:int):int
begin
    Result := a*a;
end

procedure p(name:string)
begin
    print("hello" + name);
end

var
x:int;
begin
x := 10;

while x > 0 do
begin
    print(x);
    x := x -1;
    if x == 3 then
    begin
        break;
    end
end

end