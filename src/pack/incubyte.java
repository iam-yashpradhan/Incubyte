package pack;

public class incubyte {
    public static int Add(String numbers){
        int sum=0;String temp[];
        if(numbers.equals(""))
            return  0;
        if(numbers.length()>2 && numbers.substring(0,2).equals("//")){
            int newLinePosition=numbers.indexOf('\n');
            String delim=numbers.substring(2,newLinePosition);
            numbers=numbers.substring(newLinePosition+1);
            temp=numbers.split(delim);
        }else if(numbers.contains(",")||numbers.contains("\n")){
            temp=numbers.split(",|\n");
        }else{
            return Integer.parseInt(numbers);
        }
        for(int i=0;i< temp.length;i++){
            sum+=Integer.parseInt(temp[i]);
        }
        return sum;
    }

    public static void main(String args[]){
        String test="//;\n2;4";
        System.out.println(Add(test));
    }
}