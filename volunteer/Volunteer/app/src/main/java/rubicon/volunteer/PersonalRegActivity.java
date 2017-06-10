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
    String regx = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_reg);
    }

    public boolean validateNumber(String string){
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void submitData(View view) {

        RadioGroup radioGenderGroup = ((RadioGroup)findViewById(R.id.radioGenderGroup));
        int radioButtonID = radioGenderGroup.getCheckedRadioButtonId();
        View radioButton = radioGenderGroup.findViewById(radioButtonID);
        int idx = radioGenderGroup.indexOfChild(radioButton);
        RadioButton r = (RadioButton) radioGenderGroup.getChildAt(idx);
        if(radioButtonID != -1)
        {
            String selectedtext = r.getText().toString();

            Intent i = new Intent(this, PersonalReg2Activity.class);

            if(((EditText)findViewById(R.id.fName)).getText().toString().equals("") || ((EditText)findViewById(R.id.sName)).getText().toString().equals("") || ((EditText)findViewById(R.id.pName)).getText().toString().equals("") || ((EditText)findViewById(R.id.age)).getText().toString().equals("") || selectedtext.equals("")){
                Context context = getApplicationContext();
                CharSequence text = "Empty Fields";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            else if(!((EditText)findViewById(R.id.fName)).getText().toString().matches(regx) || !((EditText)findViewById(R.id.sName)).getText().toString().matches(regx) || !((EditText)findViewById(R.id.pName)).getText().toString().matches(regx) || !validateNumber(((EditText)findViewById(R.id.age)).getText().toString())){
                Context context = getApplicationContext();
                CharSequence text = "Invalid Fields";
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
        else {
            Context context = getApplicationContext();
            CharSequence text = "Empty Fields";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }
}
