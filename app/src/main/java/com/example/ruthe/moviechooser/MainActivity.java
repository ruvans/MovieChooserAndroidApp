package com.example.ruthe.moviechooser;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void setAllBlack()
    {
        TextView tv0 = findViewById(R.id.movieText0);
        TextView tv1 = findViewById(R.id.movieText1);
        TextView tv2 = findViewById(R.id.movieText2);

        tv0.setTextColor(Color.BLACK);
        tv1.setTextColor(Color.BLACK);
        tv2.setTextColor(Color.BLACK);
    }

    public void makeAChoice()
    {
        TextView tv =  findViewById(R.id.movieText0);
        //tv.setText("test");


        Random rand = new Random();

        int choice = rand.nextInt(3);


        if (choice == 0) {
            tv =  findViewById(R.id.movieText0);
        }
        else if (choice == 1)
        {
            tv =  findViewById(R.id.movieText1);
        }
        else if (choice == 2)
        {
            tv =  findViewById(R.id.movieText2);
        }

        tv.setTextColor(Color.RED);
    }
    public void onButtonClick(View v)
    {
        setAllBlack();
        makeAChoice();
    }



}
