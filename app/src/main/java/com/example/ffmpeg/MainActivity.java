package com.example.ffmpeg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.arthenica.mobileffmpeg.ExecuteCallback;
import com.arthenica.mobileffmpeg.FFmpeg;
import com.arthenica.mobileffmpeg.FFmpegExecution;

public class MainActivity extends AppCompatActivity {
    FFmpeg fFmpeg;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Merge( View view ) {
        String[] c = {"-i", Environment.getExternalStorageDirectory().getPath()
                + "/Download/messi.mp4"
                , "-i", Environment.getExternalStorageDirectory().getPath()
                + "/Download/Faded.m4a"
                , "-c:v", "copy", "-c:a", "aac", "-map", "0:v:0", "-map", "1:a:0", "-shortest",
                Environment.getExternalStorageDirectory().getPath()
                        + "/Download/2Merge Video.mp4"   };
        MergeVideo(c);
    }

    private void MergeVideo(String[] co){
        FFmpeg.executeAsync(co, new ExecuteCallback() {
            @Override
            public void apply( long executionId, int returnCode ) {
                Log.d("hello" , "return  " + returnCode);
                Log.d("hello" , "executionID  " + executionId);
                Log.d("hello" , "FFMPEG  " +  new FFmpegExecution(executionId,co));

            }
        });
    }
}