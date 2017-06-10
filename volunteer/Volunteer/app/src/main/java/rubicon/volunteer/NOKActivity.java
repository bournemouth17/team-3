package rubicon.volunteer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NOKActivity extends AppCompatActivity{

    String fName;
    String sName;
    String pName;
    int age;
    String gender;
    String email;
    String phoneNo;
    String Address1;
    String Address2;
    String PostCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nok);

        Bundle b = getIntent().getExtras();
        fName = b.getString("fName");
        sName = b.getString("sName");
        pName = b.getString("pName");
        age = b.getInt("age");
        gender = b.getString("gender");
        email = b.getString("email");
        phoneNo = b.getString("phone");
        Address1 = b.getString("address1");
        Address2 = b.getString("address2");
        PostCode = b.getString("postcode");
    }

    public void submitData(View view) {

        Intent i = new Intent(this, SkillsRegActivity.class);

        if(((EditText)findViewById(R.id.NOKName)).getText().toString().equals("") || ((EditText)findViewById(R.id.Phone)).getText().toString().equals("") || ((EditText)findViewById(R.id.relation)).getText().toString().equals("")){
            Context context = getApplicationContext();
            CharSequence text = "Empty Fields";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else{
            DBHandler db = new DBHandler();
            int userID = db.insertData(fName, sName, pName, age, gender, email, phoneNo, Address1, Address2, PostCode, ((EditText)findViewById(R.id.NOKName)).getText().toString(), ((EditText)findViewById(R.id.relation)).getText().toString(), ((EditText)findViewById(R.id.Phone)).getText().toString());
            i.putExtra("userID", userID);
            startActivity(i);
        }
    }
}
