program GeussNumber
var 
    number:int;
    geuss:int;
begin
    number:=45;
    geuss :=0;
    while geuss != number do
    begin
        print("Please geuss an integer number");
        geuss := readInt();

        if(geuss == number) then
        begin
            print("You win");
            break;
        end

        if(geuss > number) then
        begin
            print("Lower");
        end
        
        if(geuss < number) then
        begin
            print("Higher");
        end
    end
end
