package rubicon.volunteer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.sql.SQLException;

public class SkillsRegActivity extends AppCompatActivity{

    int userID;
    int out;
    int in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills_reg);

        Bundle b = getIntent().getExtras();
        userID = b.getInt("userID");
    }

    public void submitData(View view) {

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

        Intent i = new Intent(this, SkillsReg2Activity.class);

        if(selectedtext.equals("") || selectedtext2.equals("")){
            Context context = getApplicationContext();
            CharSequence text = "Empty Choice";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else{
            if(selectedtext.equals("Yes")){
                out = 1;
            }
            else if(selectedtext.equals("No")){
                out = 0;
            }
            else {
                out = 2;
            }

            if(selectedtext2.equals("Yes")){
                in = 1;
            }
            else if(selectedtext2.equals("No")){
                in = 0;
            }
            else {
                in = 2;
            }

            String interests = "";
            if(((CheckBox)findViewById(R.id.Interest1)).isChecked())
                interests += "1";
            else
                interests += "0";
            if(((CheckBox)findViewById(R.id.Interest2)).isChecked())
                interests += "1";
            else
                interests += "0";
            if(((CheckBox)findViewById(R.id.Interest3)).isChecked())
                interests += "1";
            else
                interests += "0";
            if(((CheckBox)findViewById(R.id.Interest4)).isChecked())
                interests += "1";
            else
                interests += "0";
            if(((CheckBox)findViewById(R.id.Interest5)).isChecked())
                interests += "1";
            else
                interests += "0";
            if(((CheckBox)findViewById(R.id.Interest6)).isChecked())
                interests += "1";
            else
                interests += "0";
            if(((CheckBox)findViewById(R.id.Interest7)).isChecked())
                interests += "1";
            else
                interests += "0";

            i.putExtra("userID", userID);
            i.putExtra("outside", out);
            i.putExtra("inside", in);
            i.putExtra("interests", interests);

            System.out.println("DATA " + userID + "    " + out + "    " + in + "   " + interests);
            startActivity(i);
        }
    }
}
