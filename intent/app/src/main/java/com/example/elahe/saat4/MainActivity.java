package com.example.elahe.saat4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.Date;


public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {
    private TextView hours, minutes;
    private Button say;
    private int loc = 0;
    private int res=0;
    private int REQ_CODE=123;
    private int[] seda = {R.raw.clock, R.raw.ten, R.raw.minute, 0};

    private int[] sounds = {0, R.raw.one, R.raw.two, R.raw.three, R.raw.four, R.raw.five,
            R.raw.six, R.raw.seven, R.raw.eight, R.raw.nine, R.raw.ten, R.raw.eleven, R.raw.twelve,
            R.raw.thirteen, R.raw.fourteen, R.raw.fifteen, R.raw.sixteen, R.raw.seventeen, R.raw.eighteen,
            R.raw.nineteen, R.raw.twenty};


    private int[] sound2 = {0, R.raw.ten, R.raw.twenty, R.raw.thirty, R.raw.fourty, R.raw.fifty,
    };

    private int[] sound3 = {0, R.raw.bisto, R.raw.sio, R.raw.chehelo, R.raw.panjaho};

    /*****************************************************************************/

    private int[] myseda1={R.raw.recordingsaat,R.raw.recording1,R.raw.recording5,R.raw.recordingdaghighe};

    private int[] mysounds1={0,R.raw.recording1,R.raw.recording2,R.raw.recording3,R.raw.recording4,R.raw.recording5,
            R.raw.recording6,R.raw.recording7,R.raw.recording8,R.raw.recording9,R.raw.recording10,R.raw.recording12o,
            R.raw.recording13,R.raw.recording14o,R.raw.recording15,R.raw.recording16,R.raw.recording17,R.raw.recording18,
            R.raw.recording19,R.raw.recording20,
    };

    private int[] mysound31={0,R.raw.recording20o,R.raw.recording30o,R.raw.recording40o,R.raw.recording50o};

    private int[] mysound21 ={0,R.raw.recording10,R.raw.recording20,R.raw.recording30,R.raw.recording40,R.raw.recording50};
 /*****************************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView hours = (TextView) findViewById(R.id.t1);
        final TextView minutes = (TextView) findViewById(R.id.t2);
        final Button say = (Button) findViewById(R.id.btn1);
        final Button button1 = (Button) findViewById(R.id.btn2);


        say.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Date d = new Date();
                int h = d.getHours();
                int m = d.getMinutes();
                hours.setText(String.valueOf(h));
                minutes.setText(String.valueOf(m));


                int index = 0;
                seda[index++] = m == 0 ? sounds[h] : sounds[h];

                if (m < 20)
                    seda[index++] = sounds[m];
                else {
                    int m10 = m / 10;
                    int m1 = m % 10;
                    seda[index++] = m1 == 0 ? sound2[m10] : sound3[m10];

                    if (m1 != 0)
                        seda[index++] = sounds[m1];

                }


                MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.clock);
                mp.setOnCompletionListener(MainActivity.this);
                mp.start();
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult(i, REQ_CODE);
            }

           protected void onActivityResult(int requestcode, int resultcode, Intent i) {
                if (requestcode == REQ_CODE) {
                    i.getExtras();
                    i.putExtra("result", res);

                  if (res==1){
                        Date d = new Date();
                        int h = d.getHours();
                        int m = d.getMinutes();
                        hours.setText(String.valueOf(h));
                        minutes.setText(String.valueOf(m));


                        int index = 0;
                        myseda1[index++] = m == 0 ? mysounds1[h] : mysounds1[h];

                        if (m < 20)
                            myseda1[index++] = mysounds1[m];
                        else {
                            int m10 = m / 10;
                            int m1 = m % 10;
                            myseda1[index++] = m1 == 0 ? mysound21[m10] : mysound31[m10];

                            if (m1 != 0)
                                myseda1[index++] = mysounds1[m1];

                        }

                        MediaPlayer mpp = MediaPlayer.create(MainActivity.this, R.raw.clock);
                        mpp.setOnCompletionListener(MainActivity.this);
                        mpp.start();
                    }



                    if(res==2){
                        Date d = new Date();
                        int h = d.getHours();
                        int m = d.getMinutes();
                        hours.setText(String.valueOf(h));
                        minutes.setText(String.valueOf(m));


                        int index = 0;
                        seda[index++] = m == 0 ? sounds[h] : sounds[h];

                        if (m < 20)
                            seda[index++] = sounds[m];
                        else {
                            int m10 = m / 10;
                            int m1 = m % 10;
                            seda[index++] = m1 == 0 ? sound2[m10] : sound3[m10];

                            if (m1 != 0)
                                seda[index++] = sounds[m1];

                        }
                        MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.clock);
                        mp.setOnCompletionListener(MainActivity.this);
                        mp.start();
                    }

                }
            }



        });


    }



    @Override
    public void onCompletion(MediaPlayer mp) {

        if (seda[loc] != 0) {
            MediaPlayer mp2 = MediaPlayer.create(MainActivity.this, seda[loc]);
            loc++;
            mp2.setOnCompletionListener(MainActivity.this);
            mp2.start();
        }
    }


}