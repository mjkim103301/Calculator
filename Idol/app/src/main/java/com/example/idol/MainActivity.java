package com.example.idol;

import android.graphics.Matrix;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cb_twice, cb_bts;
    RadioButton rb_name1, rb_name2, rb_name3, rb_fitCenter, rb_matrix, rb_fitxy, rb_center;
    RadioGroup rGroup_idol, rGroup_scale;
    ImageView iView;
    int woman=1;//1이면 twice 0이면 bts
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb_twice=(CheckBox)findViewById(R.id.cb_twice);
        cb_bts=(CheckBox)findViewById(R.id.cb_bts);
        rb_name1=(RadioButton)findViewById(R.id.rb_name1);
        rb_name2=(RadioButton)findViewById(R.id.rb_name2);
        rb_name3=(RadioButton)findViewById(R.id.rb_name3);
        rGroup_idol=(RadioGroup)findViewById(R.id.rGroup_idol);
        iView=(ImageView)findViewById(R.id.iView);
        rb_fitCenter=(RadioButton)findViewById(R.id.rb_fitCenter);
        rb_matrix=(RadioButton)findViewById(R.id.rb_matrix);
        rb_fitxy=(RadioButton)findViewById(R.id.rb_fitxy);
        rb_center=(RadioButton)findViewById(R.id.rb_center);
        rGroup_scale=(RadioGroup) findViewById(R.id.rGroup_scale);

        cb_twice.setOnCheckedChangeListener(mCheckListener);
        cb_bts.setOnCheckedChangeListener(mCheckListener);

        rGroup_idol.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(woman==1){//twice
                    switch (checkedId){
                        case R.id.rb_name1:
                            iView.setImageResource(R.drawable.tw_chayoung);
                            break;
                        case R.id.rb_name2:
                            iView.setImageResource(R.drawable.tw_sana);
                            break;
                        case R.id.rb_name3:
                            iView.setImageResource(R.drawable.tw_nayoun);
                            break;
                    }
                }
                else{//bts
                    switch (checkedId){
                        case R.id.rb_name1:
                            iView.setImageResource(R.drawable.bts_jungguck);
                            break;
                        case R.id.rb_name2:
                            iView.setImageResource(R.drawable.bts_taehung);
                            break;
                        case R.id.rb_name3:
                            iView.setImageResource(R.drawable.bts_jimin);
                            break;
                    }
                }
            }
        });

        rGroup_scale.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                android.graphics.Matrix matrix;

                    switch (checkedId) {
                        case R.id.rb_fitCenter:
                            iView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            break;
                        case R.id.rb_matrix:
                            iView.setScaleType(ImageView.ScaleType.MATRIX);
                            matrix=new Matrix();
                            matrix.postScale(0.5f, 0.5f);
                            matrix.postRotate(45);
                            iView.setImageMatrix(matrix);
                            break;
                        case R.id.rb_fitxy:
                            iView.setScaleType(ImageView.ScaleType.FIT_XY);
                            break;
                        case R.id.rb_center:
                            iView.setScaleType(ImageView.ScaleType.CENTER);
                            break;
                    }

                    }
        });
    }

    CompoundButton.OnCheckedChangeListener mCheckListener=new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(buttonView.getId()==R.id.cb_bts){//bts radio button 선택
                cb_twice.setChecked(false);

                rb_name1.setText("정국");
                rb_name2.setText("태형");
                rb_name3.setText("지민");
                woman=0;


            }else if(buttonView.getId()==R.id.cb_twice){//twice radio button 선택
                cb_bts.setChecked(false);

                rb_name1.setText("채영");
                rb_name2.setText("사나");
                rb_name3.setText("나연");
                woman=1;
            }


        }
    };
}
