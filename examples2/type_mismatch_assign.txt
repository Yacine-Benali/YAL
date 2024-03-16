program test
function f():string
begin
    Result := "hello world";
end
var
x:int;
begin
    // x := "hello world";
    x := f();
end