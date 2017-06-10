package rubicon.volunteer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class TrainingVideo extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    VideoView videoView;
    int userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_video);
        videoView = (VideoView)findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.risk);
        Bundle b = getIntent().getExtras();
        userID = b.getInt("userID");
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setOnCompletionListener(this);
    }

    public void playVideo(View view){
        videoView.resume();
    }

    public void pauseVideo(View view){
        //videoView.pause();
        videoView.seekTo(videoView.getDuration() - 1000);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        ((Button) findViewById(R.id.goToQuiz)).setVisibility(View.VISIBLE);
        ((Button) findViewById(R.id.play)).setVisibility(View.GONE);
        ((Button) findViewById(R.id.pause)).setVisibility(View.GONE);
    }

    public void goToQuiz(View view){
        Intent i = new Intent(this, QuizActivity.class);
        i.putExtra("userID", userID);
        startActivity(i);
    }
}
