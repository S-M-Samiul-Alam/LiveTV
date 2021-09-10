package com.example.citytv.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.citytv.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Video extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    Bundle bundle;
    String videoID;
    YouTubePlayerView playerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        playerView = findViewById(R.id.playerView);
        bundle = new Bundle();
        bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            videoID = bundle.getString("videoID");
            Log.e("YOUTUBE VIDEO ID",videoID);
        }
        else
            Log.e("VIDEO ID NULL",videoID.concat(" "));
        playerView.initialize("AIzaSyAW0SG-E2trtkDTaPq_8MKlZAle53CGnhc",this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo(videoID);
        youTubePlayer.play();
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Something went wrong, Please try again", Toast.LENGTH_LONG).show();
    }
}
