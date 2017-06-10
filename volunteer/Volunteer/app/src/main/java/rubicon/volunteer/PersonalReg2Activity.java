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

public class PersonalReg2Activity extends AppCompatActivity{

    String fName;
    String sName;
    String pName;
    int age;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal2_reg);

        Bundle b = getIntent().getExtras();
        fName = b.getString("fName");
        sName = b.getString("sName");
        pName = b.getString("pName");
        age = Integer.parseInt(b.getString("age"));
        gender = b.getString("gender");

        System.out.println(fName + " " + sName + " " + pName + " " + age + " " + gender);
    }

    public void submitData(View view) throws ClassNotFoundException, SQLException {

        Intent i = new Intent(this, NOKActivity.class);

        if(((EditText)findViewById(R.id.email)).getText().toString().equals("") || ((EditText)findViewById(R.id.phoneNo)).getText().toString().equals("") || ((EditText)findViewById(R.id.Address1)).getText().toString().equals("") || ((EditText)findViewById(R.id.Address2)).getText().toString().equals("") || ((EditText)findViewById(R.id.PostCode)).getText().toString().equals("")){
            Context context = getApplicationContext();
            CharSequence text = "Empty Fields";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        else{
            if(/*email is wrong || */ ((EditText)findViewById(R.id.phoneNo)).getText().toString().length() != 11){
                Context context = getApplicationContext();
                CharSequence text = "Invalid Fields";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            else {
                i.putExtra("fName", fName);
                i.putExtra("sName", sName);
                i.putExtra("pName", pName);
                i.putExtra("age", age);
                i.putExtra("gender", gender);
                i.putExtra("email", ((EditText)findViewById(R.id.email)).getText().toString());
                i.putExtra("phone", ((EditText)findViewById(R.id.phoneNo)).getText().toString());
                i.putExtra("address1", ((EditText)findViewById(R.id.Address1)).getText().toString());
                i.putExtra("address2", ((EditText)findViewById(R.id.Address2)).getText().toString());
                i.putExtra("postcode", ((EditText)findViewById(R.id.PostCode)).getText().toString());
                startActivity(i);
            }
        }
    }

}
