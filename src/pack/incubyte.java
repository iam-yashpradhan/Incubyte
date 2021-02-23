package pack;

import java.util.ArrayList;

public class incubyte {
    public static int Add(String numbers) throws Exception {
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
        boolean neg=false;
        ArrayList<Integer> negs=new ArrayList<>();
        for(int i=0;i< temp.length;i++){
            if(!temp[i].equals("")){
                int a=Integer.parseInt(temp[i]);
                if(a<0){
                    neg=true;
                    negs.add(a);
                }else {
                    sum += a;
                }
            }
        }
        if(neg){
            throw new Exception("Negatives not allowed "+negs.toString());
        }
        return sum;
    }

    public static void main(String args[]) throws Exception {
        String test="//;\n2;-4;-4";
        System.out.println(Add(test));
    }
}

