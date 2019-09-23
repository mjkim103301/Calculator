package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {



    TextView tv_formula, tv_error;//식, 에러
    Button btn_allclear, btn_debug;//다 지우는 버튼

    public String str="";//계산해야 하는 식
    int open=0, close=0;//괄호 개수
    String check=""; //숫자: a, 연산자: b, (: c, ): d


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);

        tv_formula=(TextView)findViewById(R.id.tv_formula);
        tv_error=(TextView)findViewById(R.id.tv_error);
        btn_allclear=(Button)findViewById(R.id.btn_allclear);
        btn_debug=(Button)findViewById(R.id.btn_debug);
        //tv_menu=(TextView)findViewById(R.id.tv_menu);
        tv_formula.setText("");


        btn_allclear.setOnClickListener(new Button.OnClickListener(){//allclear 버튼 눌렀을 때

            @Override
            public void onClick(View v) {
                tv_formula.setText("");//formula 텍스트 뷰 다 지워짐.
                tv_error.setText("");//error 텍스트 뷰 다 지워짐.
                open=0;close=0;//괄호 개수 초기화됨.
                check="";

            }
        });

        btn_debug.setOnClickListener(new Button.OnClickListener(){//btn_debug 버튼 눌렀을 때

            @Override
            public void onClick(View v) {
                if(open!=close)
                    tv_error.setText("괄호의 형식이 올바르지 않습니다.");
                else if(open==close)
                    tv_error.setText("");
                for(int i=1, len=check.length();i<len; i++){
                    if(check.substring(i-1,i+1).equals("bb")){
                        tv_error.setText("연산자 사이에 숫자가 필요합니다.");
                    }
                    else if(check.substring(i-1,i+1).equals("ac")||check.substring(i-1,i+1).equals("cb")||check.substring(i-1,i+1).equals("bd")
                            ||check.substring(i-1,i+1).equals("da")||check.substring(i-1,i+1).equals("cd")){
                        tv_error.setText("괄호 주변을 확인해주세요.");
                    }
                    else if(i>1&&(check.substring(i-2,i+1).equals("bda")||check.substring(i-2,i+1).equals("acb"))){
                        tv_error.setText("괄호 주변을 확인해주세요.");
                    }
                }
            }
        });


    }

    public void btn_num(View view) {//버튼클릭리스너//숫자만
        Button button=(Button)view;
        String buttonText=button.getText().toString();
        check+="a";
        tv_formula.append(buttonText);
        //Toast.makeText(getApplicationContext(), buttonText+"button clicked", Toast.LENGTH_SHORT).show();
    }

    public void btn_oper(View view) {//버튼클릭리스너//연산자 및 괄호
        Button button=(Button)view;
        String buttonText=button.getText().toString();
        tv_formula.append(buttonText);
        switch (view.getId()){
            case R.id.btn_open:
                open++;
                check+="c";
                break;
            case R.id.btn_close:
                close++;
                check+="d";
                break;
            default:
                check+="b";
                break;
        }

    }

    public void btn_back(View view) {//지우기 버튼 눌렀을때
        str=tv_formula.getText().toString();
        tv_error.setText("");
        int len=str.length();
        if(str!=null&&len>0){
            if(str.substring(len-1,len).equals("("))
            {
                open--;
            }else if(str.substring(len-1,len).equals(")")){
                close--;
            }
            str=str.substring(0, len-1);
            check=check.substring(0, check.length()-1);
            tv_formula.setText(str);
        }

    }



    //Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    ToPostfix toPostfix;
    String getpostfix;
    Calcul calcul;//실제 계산
    public void btn_answer(View view) {//=버튼 눌렀을때
        str=tv_formula.getText().toString();
        //toPostfix=ToPostfix.getPostfix(str);
        toPostfix= new ToPostfix(str);
       getpostfix=toPostfix.getPostfix();

       //Toast.makeText(getApplicationContext(), getpostfix, Toast.LENGTH_SHORT).show();
        calcul=new Calcul(getpostfix);
        String answer=Double.toString(calcul.getAnswer());
        //Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_SHORT).show();
        //tv_menu.setText("계산식 및 답");
        tv_formula.append(" = "+answer);
    }
}

