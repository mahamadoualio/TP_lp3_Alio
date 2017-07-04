package controller.myuniversity.com.myuniversity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.telephony.SmsManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class UniversityActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);
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
        LatLng esmt = new LatLng(14.7000409,-17.4532382);
        mMap.addMarker(new MarkerOptions().position(esmt).title("ESMT").snippet("ECOLE SUPERIEUR MULTINATIONALE. contact: 338690300"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(esmt,12));

        LatLng ucad = new LatLng(14.7672880,-17.397265);
        mMap.addMarker(new MarkerOptions().position(ucad).title("UCAD").snippet("UNVERSITER CHEICK ANTA DIOP. contact: "));

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL); //Type d'affichage de la carte

        CircleOptions co=new CircleOptions().center(esmt)
                .radius(500)
                .fillColor(Color.BLUE)
                .strokeColor(Color.GREEN)
                .strokeWidth(5)
                ;
        mMap.addCircle(co);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                if(marker.getTitle().equals("ESMT"))  {
                    Intent intent= new Intent(Intent.ACTION_CALL, Uri.parse("tel:775097011"));
                    startActivity(intent);
                }
                else{
                    SmsManager sms= SmsManager.getDefault();
                    sms.sendTextMessage("775097011", null, "Hello", null, null);
                }
                return false;
            }
        });
    }
}





