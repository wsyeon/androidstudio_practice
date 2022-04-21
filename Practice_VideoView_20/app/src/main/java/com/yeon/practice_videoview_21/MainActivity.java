package com.yeon.practice_videoview_21;

import androidx.appcompat.app.AppCompatActivity;

import android.media.midi.MidiDevice;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.yeon.practice_videoview_20.R;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView; // 비디오 실행할 수 있 도와주는
    private MediaController mediaController; // 재생이나 정지와 같은 미디제어 버튼부 담당
    private String videoURL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse(videoURL);
        videoView.setMediaController(mediaController); // 미디어 제어 버튼부 세팅
        videoView.setVideoURI(uri);
        videoView.start();

    }
}