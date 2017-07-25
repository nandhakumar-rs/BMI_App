package com.example.nandhu.bmi;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
private RelativeLayout rl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.submit);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
rl = (RelativeLayout)findViewById(R.id.activity_main);





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double weight;
                double height;
                EditText edit12 = (EditText)findViewById(R.id.edit1);
                EditText edit22 = (EditText) findViewById(R.id.edit2);
                TextView text = (TextView) findViewById(R.id.result);


                    weight = Double.parseDouble(edit12.getText().toString());
                    height = Double.parseDouble(edit22.getText().toString());
                    height /= 100;
                    double result = weight / (height * height);
                    String description;
                    if (result <= 18.5) {
                        description = "Underweight!!!";
                    } else if (result > 18.5 && result <= 24.9) {
                        description = "Normal or Healthy Weight!!!";
                    } else if (result >= 25.0 && result <= 29.9) {
                        description = "Overweight!!!";
                    } else {
                        description = "Obese!!!";
                    }
                Snackbar.make(rl, "bmi calculaed", Snackbar.LENGTH_LONG).show();

                    text.setText(String.format("%.2f", result) + "\r\n " + description);

            }
        });

    }
}
