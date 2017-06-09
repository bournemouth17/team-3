package rubicon.volunteer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SelectedEvent extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String title;
    LatLng location;
    String description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_event);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Bundle b = getIntent().getExtras();
        title = b.getString("eventName");
        location = (LatLng) b.get("LatLng");
        description = b.getString("description");

        ((TextView) findViewById(R.id.eventName)).setText(title);
        ((TextView) findViewById(R.id.description)).setText(description);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng place = new LatLng(51.2076854, -1.9162612);
        mMap.addMarker(new MarkerOptions().position(place).title("Marker in Sydney").snippet("This is the description"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(place));
        mMap.setMinZoomPreference(5);
    }

    public void backToMap(View view){
        startActivity(new Intent(this, MapsActivity.class));
    }

    public void registerDetails(View view){
        startActivity(new Intent(this, PersonalRegActivity.class));
    }

}
