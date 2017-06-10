package rubicon.volunteer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.sql.SQLException;

public class SkillsRegActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills_reg);

        Bundle b = getIntent().getExtras();

    }

    protected void submitData(View view) {

        RadioGroup radioOutsideGroup = ((RadioGroup)findViewById(R.id.radioGroup1));
        int radioButtonID = radioOutsideGroup.getCheckedRadioButtonId();
        View radioButton = radioOutsideGroup.findViewById(radioButtonID);
        int idx = radioOutsideGroup.indexOfChild(radioButton);
        RadioButton r = (RadioButton) radioOutsideGroup.getChildAt(idx);
        String selectedtext = r.getText().toString();

        RadioGroup radioInsideGroup = ((RadioGroup)findViewById(R.id.radioGroup2));
        int radioButton2ID = radioInsideGroup.getCheckedRadioButtonId();
        View radioButton2 = radioInsideGroup.findViewById(radioButton2ID);
        int idx2 = radioInsideGroup.indexOfChild(radioButton2);
        RadioButton r2 = (RadioButton) radioInsideGroup.getChildAt(idx2);
        String selectedtext2 = r2.getText().toString();

        Intent i = new Intent(this, PersonalReg2Activity.class);

        if(selectedtext.equals("") || selectedtext2.equals("")){
            Context context = getApplicationContext();
            CharSequence text = "Empty Choice";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else{
            // send data
            startActivity(i);
        }
    }
}
