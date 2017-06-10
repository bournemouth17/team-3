package rubicon.volunteer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import org.w3c.dom.Text;

public class QuizFeedback extends AppCompatActivity {

    int noOfQuestions;
    int noCorrect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_feedback);
        Bundle b = getIntent().getExtras();
        noOfQuestions = b.getInt("noOfQuestions");
        noCorrect = b.getInt("noCorrect");
        ((TextView)findViewById(R.id.quizResults)).setText("You got " + noCorrect + " / " + noOfQuestions);
        if(noOfQuestions != noCorrect){
            findViewById(R.id.retryQuiz).setVisibility(View.VISIBLE);
            findViewById(R.id.finishQuiz).setVisibility(View.GONE);
        }
    }

    public void retryQuiz(View view){
        startActivity(new Intent(this, TrainingVideo.class));
    }

    public void continuePage(View view){
        Intent i = new Intent(this, UserIDEnd.class);
        startActivity(i);
    }


}
