package pack;

public class incubyte {
    public static int Add(String numbers){
        int sum=0;
        if(numbers.equals(""))
            return  0;
        String temp[]=numbers.split(",");
        sum=Integer.parseInt(temp[0])+Integer.parseInt(temp[1]);
        return sum;
    }

    public static void main(String args[]){
        String test="1,2";
        System.out.println(Add(test));
    }
}