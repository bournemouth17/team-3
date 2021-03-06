package rubicon.volunteer;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


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
        DBHandler db = new DBHandler();
        ArrayList<Event> events = db.getEvents();
        System.out.println("qertyuiop" + events.size());
        for(Event e : events) {
            System.out.println("qertyuiop" + e.getEventName());
            System.out.println("qertyuiop" + e.getDescription());
            System.out.println("qertyuiop" + e.getLang());
            System.out.println("qertyuiop" + e.getLat());

            LatLng place = new LatLng(e.getLat(), e.getLang());
            mMap.addMarker(new MarkerOptions().position(place).title(e.getEventName()).snippet(e.getDescription()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(place));
        }
        mMap.setMinZoomPreference(5);
        mMap.setOnInfoWindowClickListener(this);

    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent i = new Intent(this, SelectedEvent.class);
        i.putExtra("eventName", marker.getTitle());
        i.putExtra("description", marker.getSnippet());
        i.putExtra("LatLng", marker.getPosition());

        startActivity(i);
    }


}
