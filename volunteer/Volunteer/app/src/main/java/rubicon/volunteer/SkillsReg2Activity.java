package rubicon.volunteer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SkillsReg2Activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills_reg2);

        Bundle b = getIntent().getExtras();
        // store data from old form

    }
    protected void submitData(View view) {
        Intent i = new Intent(this, PersonalReg2Activity.class);

        //send data
        startActivity(i);

    }

}
