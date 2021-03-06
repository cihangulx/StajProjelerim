package com.bariskarapelit.stajprojesi_1;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.twilio.video.VideoTextureView;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity
{

    ImageButton circleButton,likeButton,dislikeButton;
    VideoView videoView;
    String videoPath;
    VideoTextureView  videoTextureView;
    Uri uri;
    GifImageView gifImageView;


    CountDownTimer waitTimer = null;

    int windowwidth;
    int windowheight;



    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        gifImageView= findViewById(R.id.gift);



        FrameLayout frameLayout = findViewById(R.id.frame_layout);
        LinearLayout linearLayout= findViewById(R.id.linearlayout);

        circleButton=findViewById(R.id.circle);
        dislikeButton=findViewById(R.id.dislike);
        likeButton=findViewById(R.id.like);

        frameLayout.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent event)
            {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    float xCor = event.getX();
                    float yCor = event.getY();
                    System.out.println("Touch coordinates : " +
                            String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));

                    gifImageView.setVisibility(View.VISIBLE);
                    gifImageView.setX(xCor);
                    gifImageView.setY(yCor);

                    if(waitTimer != null)
                    {
                        waitTimer.cancel();
                        waitTimer = null;
                    }
                    waitTimer = new CountDownTimer(500, 1000)
                    {

                        public void onTick(long millisUntilFinished) {}
                        public void onFinish()
                        {
                            gifImageView.setVisibility(View.INVISIBLE);
                            waitTimer.cancel();
                            waitTimer = null;
                        }
                    }.start();

                }
                return false;
            }
        });



        circleButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity.this,"Circle",Toast.LENGTH_LONG).show();

                gifImageView.setImageResource(R.drawable.circle);
            }
        });

        dislikeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity.this,"Dislike",Toast.LENGTH_LONG).show();

                gifImageView.setImageResource(R.drawable.dislikesn);

            }
        });
        likeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity.this,"Like",Toast.LENGTH_LONG).show();

                gifImageView.setImageResource(R.drawable.likesn);

            }
        });






        //videoView=findViewById(R.id.video_view_top_right);
        //Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);
        //videoView.setVideoURI(uri);


    }


}