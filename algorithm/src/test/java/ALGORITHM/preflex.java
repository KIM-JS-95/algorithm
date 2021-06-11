package ALGORITHM;

import java.util.Scanner;

public class preflex {

    public static void main(String[] args)throws IntegerStackEmptyException {
        // TODO Auto-generated method stub
        Scanner input=new Scanner(System.in);
        StackPractice stack=new StackPractice();

        String str[]=new String[100];//배열의 크기를 넉넉히 100으로 주라는 조건때문에
        System.out.println("정수 후위 수식 입력:");
        String str2[]=input.nextLine().split(" ");//str2배열에 값을 넣어 그 값을 str로 옮김

        for(int i=0;i<str2.length;i++){
            str[i]=str2[i];
        }
        int num1,num2;
        int re;

        try
        {
            for(int i=0;i<str2.length;i++)
            {
                if(str[i].equals("+"))
                {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    re=(num2+num1);
                    System.out.println(re);
                    stack.push(re);
                }
                else if(str[i].equals("-"))
                {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    re=(num2-num1);
                    System.out.println(re);
                    stack.push(re);
                }
                else if(str[i].equals("*"))
                {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    re=(num2*num1);
                    System.out.println(re);
                    stack.push(re);
                }
                else if(str[i].equals("/"))
                {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    re=(num2/num1);
                    System.out.println(re);
                    stack.push(re);
                }
                else
                {
                    re=Integer.parseInt(str[i]);
                    System.out.println(re);
                    stack.push(re);
                }
            }

            int result = stack.pop();
            if(stack.isEmpty()==false)
            {
                throw new Exception();
            }
            else
            {
                System.out.println("계산결과 = "+result);
            }
        }catch(Exception e)
        {
            System.out.println("잘못된 수식입니다.");
        }



    }

}
class StackPractice{

    private int item;
    private Node top;



    private class Node{
        int data;
        Node link;
    }



    public boolean isEmpty(){
        if(top==null){
            return true;
        }else
            return false;
    }



    public void push(int item){
        Node newNode=new Node();
        newNode.data=item;
        newNode.link=top;
        top=newNode;
    }



    public int pop() throws IntegerStackEmptyException{
        if(isEmpty()){
            System.out.println("스택이 비었음");
            throw new IntegerStackEmptyException("에러");
        }
        else{
            item=top.data;
            top=top.link;
            return item;
        }
    }

}

class IntegerStackEmptyException extends Exception {
    public IntegerStackEmptyException(String message) {
        super(message);
    }

}
