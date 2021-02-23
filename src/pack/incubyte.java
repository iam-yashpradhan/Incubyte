package pack;

public class incubyte {
    public static int Add(String numbers){
        int sum=0;
        if(numbers.equals(""))
            return  0;
        String temp[]=numbers.split(",");
        for(int i=0;i< temp.length;i++){
            sum+=Integer.parseInt(temp[i]);
        }
        return sum;
    }

    public static void main(String args[]){
        String test="1,2";
        System.out.println(Add(test));
    }
}
