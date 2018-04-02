package com.natalia.lab3;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioGroup rgroup =  (RadioGroup) findViewById(R.id.rgroup1);

        rgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                RadioButton rbutton = (RadioButton) rgroup.findViewById(i);

                switch (i) {
                    case (R.id.rbut3):
                        Intent intent = new Intent( MainActivity.this,  ActivityTwo.class);
                        startActivity(intent);
                        break;
                    case (R.id.rbut4):
                        Intent intent2 = new Intent( MainActivity.this,  ActivityThree.class);
                        startActivity(intent2);
                        break;
                    case (R.id.rbut1):
                        Intent intent3 = new Intent( MainActivity.this,  ActivityFour.class);
                        startActivity(intent3);
                        break;
                    case (R.id.rbut2):
                        Intent intent4 = new Intent( MainActivity.this,  ActivityFive.class);
                        startActivity(intent4);
                        break;
                }
            }
        });
    }
}
