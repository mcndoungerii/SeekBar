package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBarID);
        textResult = (TextView) findViewById(R.id.resultID);

        textResult.setText("Pain Level : " + seekBar.getProgress() + "/" + seekBar.getMax());
        //Listerning to seekbar events
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                textResult.setTextColor(Color.GRAY);
                textResult.setText("Pain Level : " + seekBar.getProgress() + "/" + seekBar.getMax() );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("Start Track","OnStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                if(seekBar.getProgress() >= 7){
                    textResult.setTextColor(Color.RED);
                }
                Log.d("Stop Track","OnStopTrackingTouch");
            }
        });
    }
}