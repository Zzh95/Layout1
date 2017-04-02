package com.administrator.button;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.BreakIterator;


public class MainActivity extends AppCompatActivity {
    /** Called when the activity is first created. */
    RadioButton r1 = null;
    RadioButton r2 = null;
    RadioButton r3 = null;
    RadioButton r4 = null;
    RadioGroup radioGroup = null;
    RadioButton currentRadioButton=null;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 获得单选按钮组
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        // 获得单选按钮
        r1 = (RadioButton) findViewById(R.id.a);
        r2 = (RadioButton) findViewById(R.id.b);
        r3 = (RadioButton) findViewById(R.id.c);
        r4 = (RadioButton) findViewById(R.id.d);
        r1.setClickable(true);
        // 监听单选按钮
        radioGroup.setOnCheckedChangeListener(mChangeRadio);
        Button btn1_sure =(Button)findViewById(R.id.sure);
        Button btn2_cancel =(Button)findViewById(R.id.cancel);
        btn1_sure.setOnClickListener(new btn1_sure());
        btn2_cancel.setOnClickListener(new btn2_cancel());
    }

    class btn1_sure implements OnClickListener{

        @Override
        public void onClick(View v) {

            if(currentRadioButton.getText().equals("in")){
                setTitle("你选择的答案是：是正确的！");
            }
            else{
                setTitle("你选择的答案是:是错误的！");
            }

        }

    }
    class btn2_cancel implements OnClickListener{
        /*
        (API中查找，android.widget public class RadioGroup
        void clearCheck()
        Clears the selection.

         */
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            radioGroup.clearCheck() ;
            setTitle("重新选择");
        }

    }


    private RadioGroup.OnCheckedChangeListener mChangeRadio = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == r1.getId()) {
                // 获得按钮的名称
                currentRadioButton=r1;
            } else if (checkedId == r2.getId()) {
                currentRadioButton=r2;
            } else if (checkedId == r3.getId()) {
                currentRadioButton=r3;
            } else if (checkedId == r4.getId()) {
                currentRadioButton=r4;
            }
        }
    };
}