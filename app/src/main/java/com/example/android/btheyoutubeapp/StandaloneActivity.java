package com.example.android.btheyoutubeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener{



    private String GOOGLE_API_KEY ="AIzaSyDMc0yDGYrYEjWLdCIbC37Kdnyfg8ZXKts";
    private String YOUTUBE_VIDEO_ID = "5SP7a2thq6g";
    private String YOUTUBE_PLAYLIST_ID ="PLSdMY5hvn2eGqBmmRsWm9SPwU9USkdD_H";

    private Button btnPlayVideo;
    private Button btnPlayPlaylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);

        btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);
        btnPlayPlaylist = (Button) findViewById(R.id.btnPlaylist);
        btnPlayVideo.setOnClickListener(this);
        btnPlayPlaylist.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_standalone, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()){
            case R.id.btnPlaylist:
                intent = YouTubeStandalonePlayer.createVideoIntent(this,GOOGLE_API_KEY,YOUTUBE_VIDEO_ID);
                break;
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this,GOOGLE_API_KEY,YOUTUBE_PLAYLIST_ID);
                break;
            default:


        }
        if(intent!=null){
            startActivity(intent);
        }

    }
}
