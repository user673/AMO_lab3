package com.natalia.lab3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityFour extends AppCompatActivity {

    public void error(String text ){
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityFour.this);
        builder.setTitle("Помилка !")
                .setMessage(text)
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    TextView res;
    Button button1;
    EditText text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        res = (TextView)findViewById(R.id.res4) ;
        text1= (EditText)findViewById(R.id.text4);
        button1 = (Button) findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double x = Double.parseDouble(text1.getText().toString());
                    double result = lagrange.lagrange(x, 0, 10);
                    res.setText(String.valueOf(result));
                }

                catch (NumberFormatException e ) {
                    error("Потрібно вводити числo ");
                    res.setText("Спробуйте ще раз");

                }


            }
        });


    }
}
