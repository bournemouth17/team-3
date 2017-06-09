package rubicon.volunteer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PersonalRegActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_reg);
    }

    protected void submitData(View view) {

        RadioGroup radioGenderGroup = ((RadioGroup)findViewById(R.id.radioGenderGroup));
        int radioButtonID = radioGenderGroup.getCheckedRadioButtonId();
        View radioButton = radioGenderGroup.findViewById(radioButtonID);
        int idx = radioGenderGroup.indexOfChild(radioButton);
        RadioButton r = (RadioButton) radioGenderGroup.getChildAt(idx);
        String selectedtext = r.getText().toString();

        Intent i = new Intent(this, PersonalReg2Activity.class);

        if(((EditText)findViewById(R.id.fName)).getText().toString().equals("") || ((EditText)findViewById(R.id.sName)).getText().toString().equals("") || ((EditText)findViewById(R.id.pName)).getText().toString().equals("") || ((EditText)findViewById(R.id.age)).getText().toString().equals("") || selectedtext.equals("")){
            Context context = getApplicationContext();
            CharSequence text = "Empty Fields";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else{
            i.putExtra("fName", ((EditText)findViewById(R.id.fName)).getText().toString());
            i.putExtra("sName", ((EditText)findViewById(R.id.sName)).getText().toString());
            i.putExtra("pName", ((EditText)findViewById(R.id.pName)).getText().toString());
            i.putExtra("age", ((EditText)findViewById(R.id.age)).getText().toString());
            i.putExtra("gender", selectedtext);
            startActivity(i);
        }
    }
}
