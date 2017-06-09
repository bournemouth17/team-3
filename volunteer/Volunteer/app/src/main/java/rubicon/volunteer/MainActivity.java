package rubicon.volunteer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goToMaps(View view){
        startActivity(new Intent(this, MapsActivity.class));
    }

    public void goToPReg(View view){
        startActivity(new Intent(this, PersonalRegActivity.class));
    }
}