package com.example.calculator;
import java.util.Stack;

public class Calcul {
    Stack<String> s_answer=new Stack();
    String getpostfix="";//postfix한 값
    double Answer=0.0;//답
    String num=" ";//임시저장
    double num2=0.0;
    Calcul(String getpostfix){

        this.getpostfix=getpostfix;
    }

    Double getAnswer(){

        for(int i=0, len=getpostfix.length();i<len;i++){
            if(getpostfix.charAt(i)>='0'&& getpostfix.charAt(i)<='9'){

                num+=getpostfix.charAt(i);
                if(getpostfix.charAt(i+1)==' '){//숫자 영역이 끝났으면
                    s_answer.push(num);
                    num=" ";
                }

            }
            else if(getpostfix.charAt(i)==' '){//공백이면 아무것도 안해

            }
            else{//연산자면 계산하기
                num2=Double.parseDouble(s_answer.peek());
                s_answer.pop();
                if(s_answer.empty())
                    break;
                double num1=Double.parseDouble(s_answer.peek());
                s_answer.pop();
                switch (getpostfix.charAt(i)){
                    case '+':
                        Answer=num1+num2;
                        break;
                    case '-':
                        Answer=num1-num2;
                        break;
                    case '*':
                        Answer=num1*num2;
                        break;
                    case '/':
                        Answer=num1/num2;
                        break;
                }
                s_answer.push(Double.toString(Answer));

            }
        }
        if(s_answer.empty()){
            Answer=num2;
        }else{
            Answer=Double.parseDouble(s_answer.peek());
        }

        return Answer;
    }

}
