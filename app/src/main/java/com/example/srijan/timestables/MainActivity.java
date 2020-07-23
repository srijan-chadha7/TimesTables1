package com.example.srijan.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTableListView;
    public void generate(int timesTableNumber){
        ArrayList<String> timesTableContent=new ArrayList<String>();

        for(int j=1;j<=10;j++)
        {
            timesTableContent.add(Integer.toString(timesTableNumber*j));
        }
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTableContent);
        timesTableListView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekBaar=findViewById(R.id.timesTableSeekBaar);
        timesTableListView=findViewById(R.id.timesTableListView);
        int max=20;
        int initial=1;

        timesTableSeekBaar.setMax(max);
        timesTableSeekBaar.setProgress(initial);
        generate(1);


        timesTableSeekBaar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("Seekbar Value",Integer.toString(i));
                int min=1;
                int timesTableNumber;
                if(i<min)
                {
                    timesTableNumber=min;
                    timesTableSeekBaar.setProgress(min);
                }
                else
                {
                    timesTableNumber=i;
                }

                generate(timesTableNumber);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
