package rubicon.volunteer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PersonalReg2Activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal2_reg);

        Bundle b = getIntent().getExtras();
        String fName = b.getString("fName");
        String sName = b.getString("sName");
        String pName = b.getString("pName");
        int age = Integer.parseInt(b.getString("age"));
        String gender = b.getString("gender");

        System.out.println(fName + " " + sName + " " + pName + " " + age + " " + gender);
    }

}
