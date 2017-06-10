package rubicon.volunteer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class SkillsReg2Activity extends AppCompatActivity{

    int userID;
    int out;
    int in;
    String interests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills_reg2);

        Bundle b = getIntent().getExtras();
        userID = b.getInt("userID");
        out = b.getInt("outside");
        in = b.getInt("inside");
        interests = b.getString("Interests");
    }

    public void submitData(View view) {
        Intent i = new Intent(this, TrainingVideo.class);

        if(((CheckBox)findViewById(R.id.Interest8)).isChecked())
            interests += "1";
        else
            interests += "0";
        if(((CheckBox)findViewById(R.id.Interest9)).isChecked())
            interests += "1";
        else
            interests += "0";
        if(((CheckBox)findViewById(R.id.Interest10)).isChecked())
            interests += "1";
        else
            interests += "0";
        if(((CheckBox)findViewById(R.id.Interest11)).isChecked())
            interests += "1";
        else
            interests += "0";
        if(((CheckBox)findViewById(R.id.Interest12)).isChecked())
            interests += "1";
        else
            interests += "0";
        if(((CheckBox)findViewById(R.id.Interest13)).isChecked())
            interests += "1";
        else
            interests += "0";
        if(((CheckBox)findViewById(R.id.Interest14)).isChecked())
            interests += "1";
        else
            interests += "0";
        if(((CheckBox)findViewById(R.id.Interest15)).isChecked())
            interests += "1";
        else
            interests += "0";
        if(((CheckBox)findViewById(R.id.Interest16)).isChecked())
            interests += "1";
        else
            interests += "0";
        if(((CheckBox)findViewById(R.id.Interest15)).isChecked())
            interests += "1";
        else
            interests += "0";
        if(((CheckBox)findViewById(R.id.Interest16)).isChecked())
            interests += "1";
        else
            interests += "0";
        if(((CheckBox)findViewById(R.id.Interest17)).isChecked())
            interests += "1";
        else
            interests += "0";
        if(((CheckBox)findViewById(R.id.Interest18)).isChecked())
            interests += "1";
        else
            interests += "0";

        DBHandler db = new DBHandler();
        System.out.println("DATA " + userID + "    " + out + "    " + in + "   " + interests);
        db.insertSkillsets(userID, out, in, interests);
        startActivity(i);

    }

}
