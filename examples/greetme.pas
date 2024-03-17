program GreetMe
procedure greetme(name:string)
begin
    print("Hello Mr."+name);
end

var
name:string;
begin
    print("please enter you name:");
    name:=readString();
    greetme(name);
end