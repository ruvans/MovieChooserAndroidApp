package com.example.ruthe.moviechooser;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements ChangeTextDialog.OnInputListener{
    private static final String SAVED_DATA_FILE = "moviedata.txt";
    private static final String SEPERATOR = ",";
    // The following are used for the shake detection
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restoreSavedData();
        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
                setAllBlack();
                makeAChoice();
                makeSomeNoise();
            }
        });
    }


    protected void makeSomeNoise()
    {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.dice_roll);
        mp.start();
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
        saveNewData();
    }

    private void saveNewData()
    {

        String newData = createDataString();
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(SAVED_DATA_FILE);
            file.delete();

            fileOutputStream = openFileOutput(SAVED_DATA_FILE,  MODE_PRIVATE);
            fileOutputStream.write(newData.getBytes());

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null)
            {
                try {fileOutputStream.close();}
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private void restoreSavedData() {
        String data = getDataString();
        if (data.contains(SEPERATOR)) {
            String movieData[] = data.split(SEPERATOR);

            TextView tv = findViewById(R.id.movieText0);
            tv.setText(movieData[0]);

            tv = findViewById(R.id.movieText1);
            tv.setText(movieData[1]);

            tv = findViewById(R.id.movieText2);
            tv.setText(movieData[2]);

            tv = findViewById(R.id.movieText3);
            tv.setText(movieData[3]);

            tv = findViewById(R.id.movieText4);
            tv.setText(movieData[4]);

            tv = findViewById(R.id.movieText5);
            tv.setText(movieData[5]);

            tv = findViewById(R.id.movieText6);
            tv.setText(movieData[6]);

            tv = findViewById(R.id.movieText7);
            tv.setText(movieData[7]);

            tv = findViewById(R.id.movieText8);
            tv.setText(movieData[8]);

            tv = findViewById(R.id.movieText9);
            tv.setText(movieData[9]);
        }
    }

    private String getDataString()
    {
        String savedData="";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput(SAVED_DATA_FILE);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String text;

            while ((text = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(text).append("\n");
            }
            savedData = stringBuilder.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return savedData;
    }
    private String createDataString()
    {
        TextView tv =  findViewById(R.id.movieText0);
        String newData=tv.getText().toString();
        tv =  findViewById(R.id.movieText1);
        newData = newData + SEPERATOR + tv.getText().toString();
        tv =  findViewById(R.id.movieText2);
        newData = newData + SEPERATOR + tv.getText().toString();
        tv =  findViewById(R.id.movieText3);
        newData = newData + SEPERATOR + tv.getText().toString();
        tv =  findViewById(R.id.movieText4);
        newData = newData + SEPERATOR + tv.getText().toString();
        tv =  findViewById(R.id.movieText5);
        newData = newData + SEPERATOR + tv.getText().toString();
        tv =  findViewById(R.id.movieText6);
        newData = newData + SEPERATOR + tv.getText().toString();
        tv =  findViewById(R.id.movieText7);
        newData = newData + SEPERATOR + tv.getText().toString();
        tv =  findViewById(R.id.movieText8);
        newData = newData + SEPERATOR + tv.getText().toString();
        tv =  findViewById(R.id.movieText9);
        newData = newData + SEPERATOR + tv.getText().toString();
        return newData;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }
}
