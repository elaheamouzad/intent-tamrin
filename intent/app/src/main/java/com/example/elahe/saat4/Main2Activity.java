package com.example.elahe.saat4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main2Activity extends AppCompatActivity {
    private int RES_CODE=1;
    int res =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();


        final RadioButton myvoice = (RadioButton) findViewById(R.id.r1);
        final RadioButton radio = (RadioButton) findViewById(R.id.r2);

        RadioGroup rg=(RadioGroup)findViewById(R.id.rg1) ;
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.r1:
                        res=1;
                    case R.id.r2:
                        res=2;
                }

            }
        });
        i.putExtra("result",res);
        setResult(RES_CODE,i);
        finish();


    }


  }


