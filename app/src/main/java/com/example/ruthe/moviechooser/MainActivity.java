package com.example.ruthe.moviechooser;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements ChangeTextDialog.OnInputListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    protected void setAllBlack()
    {
        TextView tv = findViewById(R.id.movieText0);
        tv.setTextColor(Color.BLACK);
        tv = findViewById(R.id.movieText1);
        tv.setTextColor(Color.BLACK);
        tv = findViewById(R.id.movieText2);
        tv.setTextColor(Color.BLACK);
        tv = findViewById(R.id.movieText3);
        tv.setTextColor(Color.BLACK);
        tv = findViewById(R.id.movieText4);
        tv.setTextColor(Color.BLACK);
        tv = findViewById(R.id.movieText5);
        tv.setTextColor(Color.BLACK);
        tv = findViewById(R.id.movieText6);
        tv.setTextColor(Color.BLACK);
        tv = findViewById(R.id.movieText7);
        tv.setTextColor(Color.BLACK);
        tv = findViewById(R.id.movieText8);
        tv.setTextColor(Color.BLACK);
        tv = findViewById(R.id.movieText9);
        tv.setTextColor(Color.BLACK);
    }

    protected TextView getTextviewByNum(int movieNum)
    {
        TextView tv =  findViewById(R.id.movieText0);

        if (movieNum == 0) {
            tv =  findViewById(R.id.movieText0);
        }
        else if (movieNum == 1)
        {
            tv =  findViewById(R.id.movieText1);
        }
        else if (movieNum == 2)
        {
            tv =  findViewById(R.id.movieText2);
        }
        else if (movieNum == 3)
        {
            tv =  findViewById(R.id.movieText3);
        }
        else if (movieNum == 4)
        {
            tv =  findViewById(R.id.movieText4);
        }
        else if (movieNum == 5)
        {
            tv =  findViewById(R.id.movieText5);
        }
        else if (movieNum == 6)
        {
            tv =  findViewById(R.id.movieText6);
        }
        else if (movieNum == 7)
        {
            tv =  findViewById(R.id.movieText7);
        }
        else if (movieNum == 8)
        {
            tv =  findViewById(R.id.movieText8);
        }
        else if (movieNum == 9)
        {
            tv =  findViewById(R.id.movieText9);
        }
        return tv;
    }

    public void makeAChoice()
    {
        Random rand = new Random();
        int choice = rand.nextInt(11);
        TextView tv = getTextviewByNum(choice);
        tv.setTextColor(Color.RED);
    }
    public void onButtonClick(View v)
    {
        setAllBlack();
        makeAChoice();

    }

    public void movie0Clicked(View v)
    {
        movieClicked(0);
    }
    public void movie1Clicked(View v)
    {
        movieClicked(1);
    }
    public void movie2Clicked(View v)
    {
        movieClicked(2);
    }
    public void movie3Clicked(View v)
    {
        movieClicked(3);
    }
    public void movie4Clicked(View v)
    {
        movieClicked(4);
    }
    public void movie5Clicked(View v)
    {
        movieClicked(5);
    }
    public void movie6Clicked(View v)
    {
        movieClicked(6);
    }
    public void movie7Clicked(View v)
    {
        movieClicked(7);
    }
    public void movie8Clicked(View v)
    {
        movieClicked(8);
    }
    public void movie9Clicked(View v)
    {
        movieClicked(9);
    }
    private void movieClicked(int position )
    {
        ChangeTextDialog newTextDialog = new ChangeTextDialog();
        newTextDialog.MovieNum=position;
        newTextDialog.show(getFragmentManager(), "ChangeTextDialog");
    }

    @Override
    public void sendInput(String input, int movieNum) {
        TextView tv = getTextviewByNum(movieNum);
        tv.setText(input);
    }
}
