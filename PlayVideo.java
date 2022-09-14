package com.daasuu.videorecordingporject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


public class PlayVideo extends AppCompatActivity {

    VideoView simpleVideoView;
    MediaController mediaControls;
    Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        simpleVideoView = (VideoView) findViewById(R.id.simpleVideoView);



//        if (Build.VERSION.SDK_INT <= 19) {
//            Intent i = new Intent();
//            i.setType("video/*");
//            i.setAction(Intent.ACTION_GET_CONTENT);
//            i.addCategory(Intent.CATEGORY_OPENABLE);
//            startActivityForResult(i, 20);
//        } else if (Build.VERSION.SDK_INT > 19) {
//            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
//            startActivityForResult(intent, 20);
//        }




        if (mediaControls == null) {
            // create an object of media controller class
            mediaControls = new MediaController(PlayVideo.this);
            mediaControls.setAnchorView(simpleVideoView);
        }
        // set the media controller for video view
        simpleVideoView.setMediaController(mediaControls);
        // set the uri for the video view
        String filePath = "file://" + PathModel.pathurl;
        Uri videoUri = Uri.parse(filePath);
        simpleVideoView.setVideoURI(videoUri);
        // start a video
        simpleVideoView.start();

        // implement on completion listener on video view
        simpleVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getApplicationContext(), "Thank You...!!!", Toast.LENGTH_LONG).show(); // display a toast when an video is completed
            }
        });
        simpleVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(getApplicationContext(), "Oops An Error Occur While Playing Video...!!!", Toast.LENGTH_LONG).show(); // display a toast when an error is occured while playing an video
                return false;
            }
        });


    }



}