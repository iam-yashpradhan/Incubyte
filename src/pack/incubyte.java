package pack;

import java.util.ArrayList;

public class incubyte {
    public static int Add(String numbers) throws Exception {
        int sum=0;String temp[];
        ArrayList<String> delimiters=new ArrayList<>();
        if(numbers.equals(""))
            return  0;
        if(numbers.length()>2 && numbers.substring(0,2).equals("//")){
            int newLinePosition=numbers.indexOf('\n');
            String delims=numbers.substring(2,newLinePosition);
            for(int i=0;i<delims.length();i++){
                if(delims.charAt(i)=='['){
                    int j=i;
                    while(delims.charAt(i)!=']')
                        i++;
                    String delim=delims.substring(j+1,i);
                    delimiters.add(delim);
                }
            }
            numbers=numbers.substring(newLinePosition+1);
            String delimsList="";
            for(int i=0;i< delimiters.size();i++){
                String delim=delimiters.get(i);
                if(i+1==delimiters.size()){
                    delimsList+=delim;
                    break;
                }
                delimsList+=delim+"|";
            }
            temp=numbers.split(delimsList);
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
                    if(a>1000)
                        a=0;
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
        String test="//[%][,;]\n4%5,;4";
        System.out.println(Add(test));
    }
}

