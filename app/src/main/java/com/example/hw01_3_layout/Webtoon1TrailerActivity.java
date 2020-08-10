package com.example.hw01_3_layout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Webtoon1TrailerActivity extends AppCompatActivity {

    VideoView vv;
    boolean playContinue = true;

    private int stopPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webtoon1_trailer);

        System.out.println("Webtoon1 Trailer Activity onCreate");

        String path = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";  //영상 링크

        vv = findViewById(R.id.vv);

        // Uri videoUri = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.test_video_01);
        //Uri videoUri = Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");

        vv.setVideoPath(path);

        MediaController mediaController = new MediaController(vv.getContext());
        mediaController.setAnchorView(vv);
        // mediaController.setPadding(0,0,0,40);

        vv.setMediaController(mediaController);
        vv.start();

       /* vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int width, int height) {


                    }
                });
            }
        }); */
    }

    @Override
    protected void onPause() {

        System.out.println("Webtoon1 Trailer Activity onPause");

        VideoView vv = findViewById(R.id.vv);
        if(vv.canPause()){
            stopPosition = vv.getCurrentPosition();
            vv.pause();
        }

        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Webtoon1 Trailer Activity onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("Webtoon1 Trailer Activity onResume");

        VideoView vv = findViewById(R.id.vv);
        if(playContinue) {
            if (stopPosition > 0) {
                vv.seekTo(stopPosition);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Webtoon1 Trailer Activity onStart");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("Webtoon1 Trailer Activity onRestart");  // 이어서 볼 것인지 물어보는 다이얼로그 띄우기


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("영상을 이어서 시청하시겠습니까??");
        AlertDialog alertDialog_;
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                    playContinue = true;
            }
        });

        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                playContinue = false;
                vv.seekTo(0);
            }
        });


        alertDialog_ = builder.create();
        alertDialog_.show();
    }

    @Override
    protected void onDestroy() {   //stopPlayback -> 영상 완전히 멈추고 나갔다 들어오면 처음부터 재생
        System.out.println("Webtoon1 Trailer Activity onDestroy");

        VideoView vv = findViewById(R.id.vv);
        vv.seekTo(0);
        vv.stopPlayback();
        super.onDestroy();
    }
}
