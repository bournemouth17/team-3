package rubicon.volunteer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class QuizActivity extends AppCompatActivity {

    private SwipeFlingAdapterView flingContainer;
    private int noOfQuestionsAnswered = 0;
    private int noRight = 0;
    private String[] quizQuestions = {"Safety takes a break", "Eye protection is not needed when drilling", "Flip flops are not suitable footwear", "Gloves and a helmet are needed while operating a sledge hammer", "PPE needs to be worn at all times"};
    private Boolean[] quizAnswers = {false, false, true, true, false};
    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;

    int userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);
        al = new ArrayList<>();
        Bundle b = getIntent().getExtras();
        userID = b.getInt("userID");
        for(int i = 0; i < quizQuestions.length; i++){
            al.add(quizQuestions[i]);
        }
        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.helloText, al );


        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                al.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                System.out.println("left");
                if(quizAnswers[noOfQuestionsAnswered] == false){
                    noRight++;
                }
                noOfQuestionsAnswered++;
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                System.out.println("right");
                if(quizAnswers[noOfQuestionsAnswered] == true){
                    noRight++;
                }
                noOfQuestionsAnswered++;
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                if(itemsInAdapter == 0){
                    Intent i = new Intent(QuizActivity.this, QuizFeedback.class);
                    i.putExtra("userID", userID);
                    i.putExtra("noOfQuestions", noOfQuestionsAnswered);
                    i.putExtra("noCorrect", noRight);
                    startActivity(i);
                    System.out.println("Quiz Ended");
                }
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });

    }


}
