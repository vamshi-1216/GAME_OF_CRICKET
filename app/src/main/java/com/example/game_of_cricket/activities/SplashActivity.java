package com.example.game_of_cricket.activities;//

import android.annotation.SuppressLint;
import android.content.Intent;// Intent is used to start a new activity.
import android.media.MediaPlayer;
import android.net.Uri;//Uri is used to parse the video resource.
import android.os.Bundle;//Bundle is used to pass data between activities.
import android.widget.VideoView;//VideoView is used to play video content.
import androidx.appcompat.app.AppCompatActivity;// AppCompatActivity is the base class for activities that use the support library action bar features.
import com.example.game_of_cricket.R;// R is the resource class that contains references to all resources in the app, such as layouts, strings, and drawables.

@SuppressLint("CustomSplashScreen")//suppressLint is used to suppress warnings related to custom splash screens.
public class SplashActivity extends AppCompatActivity {
    private VideoView splashVideo;// VideoView is used to display the splash video.
    // and declared as a member variable so it can be accessed in multiple methods.

    @Override// This method is called when the activity is first created.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);// Call the superclass onCreate method to perform default initialization.
        setContentView(R.layout.activity_splash_screen);//set the content view to the splash screen layout.

        splashVideo = findViewById(R.id.splashVideo);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.goc_splash_clean;//string to access the video resource in the raw folder. android.resource:// is a URI scheme that allows access to resources in the app's package.
        Uri uri = Uri.parse(videoPath);// Parse the video path string into a Uri object.
        splashVideo.setVideoURI(uri);// Set the video URI for the VideoView to play.

        splashVideo.setOnCompletionListener( new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp){
            // Start MainActivity when video completes
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();}
        });

        splashVideo.start();
    }

    @Override//pause and resume methods are overridden to pause and resume the video when the activity is paused and resumed, respectively.
    protected void onPause() {
        super.onPause();
        if (splashVideo != null) {
            splashVideo.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (splashVideo != null) {
            splashVideo.start();
        }
    }
}
