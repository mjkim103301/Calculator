package com.example.calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ToPostfix {

    Stack<Character> oper=new Stack();//연산자
    Queue<Character> num=new LinkedList();//숫자
    String postfix="";//postfix로 바꿔서 저장할 string
    String formula="";//텍스트 뷰에서 받아온 식
     ToPostfix(String formula){
        this.formula=formula;

    }
     public String getPostfix(){
        for(int i=0;i<formula.length();i++) {
            switch (formula.charAt(i)) {
                case '+':
                case '-':
                    while (!num.isEmpty()) {//num이 비워질 때까지
                        postfix += num.peek();
                        num.remove();

                    }
                    postfix+=" ";
                    if (!oper.empty()) {//연산자가 있으면
                        if (oper.peek()!= '(') {//괄호가 아니면
                            while (!oper.empty()) {//oper가 비워질 때까지

                                if (oper.peek()=='(') {

                                    break;
                                } else {
                                    postfix += oper.peek();
                                    oper.pop();
                                    oper.push(formula.charAt(i));
                                    break;
                                }

                            }
                            postfix+=" ";
                            break;
                        }
                        oper.push(formula.charAt(i));

                        break;
                    } else {//연산자가 없으면
                        oper.add(formula.charAt(i));
                        break;
                    }

                case '*':
                case '/':
                case '%':
                    while (!num.isEmpty()) {//num이 비워질 때까지
                        postfix += num.peek();
                        num.remove();
                    }
                    postfix+=" ";
                    oper.push(formula.charAt(i));
                    break;

                case '(':
                    oper.push(formula.charAt(i));
                    break;
                case ')':
                    while (!num.isEmpty()) {//num이 비워질 때까지
                        postfix += num.peek();
                        num.remove();

                    }
                    postfix+=" ";
                    while (oper.peek()!='(') {// ( 일 때까지
                        postfix += oper.peek();
                        oper.pop();
                        postfix+=" ";
                    }
                    oper.pop();//닫는괄호 없애려고
                    break;

                default://숫자면 큐에 다 넣어
                    num.add(formula.charAt(i));
                    break;

            }
        }
            while(!num.isEmpty()){
                postfix+=num.peek();
                num.remove();
                postfix+=" ";

            }

            while(!oper.empty()){
                postfix+=oper.peek();
                oper.pop();
                postfix+=" ";

            }

           return postfix;
    }

}

