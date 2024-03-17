program test
    function hello(name:string):string
    begin
        Result := "hello Mr." + name;
    end

var res:string;
begin
    res:= hello(res);
    print(res);
end