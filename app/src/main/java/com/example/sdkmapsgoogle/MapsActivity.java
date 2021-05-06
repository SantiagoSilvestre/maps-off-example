package com.example.sdkmapsgoogle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.UrlTileProvider;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

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
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        TileProvider coordTileProvider = new CoordTileProvider(this.getApplicationContext());
        mMap.addTileOverlay(new TileOverlayOptions().tileProvider(coordTileProvider));
        //TileProvider coordTileProvider = new CoordTileProvider(this.getApplicationContext());
        //mMap.addTileOverlay( new TileOverlayOptions().tileProvider(coordTileProvider));




        // Add a marker in Sydney and move the camera
        LatLng home = new LatLng( -19.89341963453878, -54.33233275855935);
        LatLng home2 = new LatLng( -23.54794683376847, -46.44415515621578);

        mMap.addMarker(new MarkerOptions().position(home).title("talhao 01"));
        mMap.addMarker(new MarkerOptions().position(home2).title("talhao 02"));


        PolygonOptions polygonOptions = new PolygonOptions();
        PolygonOptions polygonOptions2 = new PolygonOptions();

        polygonOptions2.add(new LatLng(-23.54794683376847, -46.44415515621578));
        polygonOptions2.add(new LatLng(-23.52245099685995, -46.44827502923972));
        polygonOptions2.add(new LatLng(-23.521821407520946, -46.524149357430446));
        polygonOptions2.add(new LatLng(-23.588226471542743, -46.47539752664726));

        polygonOptions.add(new LatLng(-19.89341963453878, -54.33233275855935));
        polygonOptions.add(new LatLng(-19.88799408968003, -54.33858874535068));
        polygonOptions.add(new LatLng(-19.88149006801454, -54.33259242491638));
        polygonOptions.add(new LatLng(-19.88750930526031, -54.32709463535));
        polygonOptions.add(new LatLng(-19.90239614498583, -54.31146960669801));
        polygonOptions.add(new LatLng(-19.90268748186178, -54.31142376257046));
        polygonOptions.add(new LatLng(-19.90380861329512, -54.31158642779039));
        polygonOptions.add(new LatLng(-19.90423517275959, -54.31014172769361));
        polygonOptions.add(new LatLng(-19.90444992269569, -54.30884041205761));
        polygonOptions.add(new LatLng(-19.90513406467959, -54.30762782141502));
        polygonOptions.add(new LatLng(-19.90498960493235, -54.30734444188376));
        polygonOptions.add(new LatLng(-19.90556761800493, -54.30638689370452));
        polygonOptions.add(new LatLng(-19.90630720797065, -54.3056431123083));
        polygonOptions.add(new LatLng(-19.90631721146246, -54.30460671547007));
        polygonOptions.add(new LatLng(-19.90652695399256, -54.30381344740288));
        polygonOptions.add(new LatLng(-19.90675864088691, -54.30267608478049));
        polygonOptions.add(new LatLng(-19.90698485231535, -54.30201489961451));
        polygonOptions.add(new LatLng(-19.90687388990458, -54.30065416520142));
        polygonOptions.add(new LatLng(-19.90621335425267, -54.29969749361642));
        polygonOptions.add(new LatLng(-19.90476357103108, -54.29932636262394));
        polygonOptions.add(new LatLng(-19.90439451452024, -54.29955900560976));
        polygonOptions.add(new LatLng(-19.90402326751572, -54.29966048215172));
        polygonOptions.add(new LatLng(-19.90197842288847, -54.29954576426525));
        polygonOptions.add(new LatLng(-19.90058188885956, -54.29853279202593));
        polygonOptions.add(new LatLng(-19.90013168686768, -54.29820624342818));
        polygonOptions.add(new LatLng(-19.90844895292043, -54.28810611478745));
        polygonOptions.add(new LatLng(-19.89950628056519, -54.28008421789206));
        polygonOptions.add(new LatLng(-19.89981347609591, -54.27904341491191));
        polygonOptions.add(new LatLng(-19.90000633290365, -54.27839485181266));
        polygonOptions.add(new LatLng(-19.91029720838811, -54.26667433447487));
        polygonOptions.add(new LatLng(-19.91079304050822, -54.26748580936339));
        polygonOptions.add(new LatLng(-19.91177927267638, -54.26809291878602));
        polygonOptions.add(new LatLng(-19.91290546278758, -54.26845776683695));
        polygonOptions.add(new LatLng(-19.91383413972142, -54.26948390584521));
        polygonOptions.add(new LatLng(-19.91431595567692, -54.269928294173));
        polygonOptions.add(new LatLng(-19.91481202777714, -54.270683994968));
        polygonOptions.add(new LatLng(-19.91520597523279, -54.27049693671049));
        polygonOptions.add(new LatLng(-19.9154400768612, -54.27078335106513));
        polygonOptions.add(new LatLng(-19.91551540791487, -54.2707827888466));
        polygonOptions.add(new LatLng(-19.91625230817273, -54.27068231412685));
        polygonOptions.add(new LatLng(-19.91656709704639, -54.2706610757233));
        polygonOptions.add(new LatLng(-19.916734896473, -54.2706934379133));
        polygonOptions.add(new LatLng(-19.91678425783021, -54.2707679529227));
        polygonOptions.add(new LatLng(-19.91692101704795, -54.27077848285582));
        polygonOptions.add(new LatLng(-19.91695236100237, -54.27084640174495));
        polygonOptions.add(new LatLng(-19.91719114193308, -54.27148810586669));
        polygonOptions.add(new LatLng(-19.91987722628395, -54.27873366060458));
        polygonOptions.add(new LatLng(-19.92201228294825, -54.28448615057957));
        polygonOptions.add(new LatLng(-19.92200297445753, -54.28471972131101));
        polygonOptions.add(new LatLng(-19.91697459359962, -54.31884021139246));
        polygonOptions.add(new LatLng(-19.91268596363154, -54.34648090303388));
        polygonOptions.add(new LatLng(-19.91203598745137, -54.3516477762123));
        polygonOptions.add(new LatLng(-19.90992039271399, -54.35224293000511));
        polygonOptions.add(new LatLng(-19.91075032118034, -54.35085098805772));
        polygonOptions.add(new LatLng(-19.90021171125567, -54.34971116080757));
        polygonOptions.add(new LatLng(-19.89014929302798, -54.3404698309652));
        polygonOptions.add(new LatLng(-19.89547247978359, -54.33415707458737));
        polygonOptions.add(new LatLng(-19.89341963453878, -54.33233275855935));

        mMap.addPolygon(polygonOptions);
        mMap.addPolygon(polygonOptions2);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, 12));

    }


    private class CoordTileProvider implements TileProvider {

        private static final int TILE_SIZE_DP = 256;


        private final float scaleFactor;

        private final Bitmap borderTile;

        public CoordTileProvider(Context context) {
            /* Scale factor based on density, with a 0.6 multiplier to increase tile generation
             * speed */
            scaleFactor = context.getResources().getDisplayMetrics().density * 0.6f;
            Paint borderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            borderPaint.setStyle(Paint.Style.STROKE);
            borderTile = Bitmap.createBitmap((int) (TILE_SIZE_DP * scaleFactor),
                    (int) (TILE_SIZE_DP * scaleFactor), android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(borderTile);
            canvas.drawRect(0, 0, TILE_SIZE_DP * scaleFactor, TILE_SIZE_DP * scaleFactor,
                    borderPaint);
        }

        @Override
        public Tile getTile(int x, int y, int zoom) {

            byte[] bitmapData;
            {

                Bitmap coordTile = drawTileCoords(x, y, zoom);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                coordTile.compress(Bitmap.CompressFormat.PNG, 0, stream);
                bitmapData = stream.toByteArray();
            }
            return new Tile((int) (TILE_SIZE_DP * scaleFactor),
                    (int) (TILE_SIZE_DP * scaleFactor), bitmapData);
        }

        private Bitmap drawTileCoords(int x, int y, int zoom) {
            // Synchronize copying the bitmap to avoid a race condition in some devices.
            Bitmap copy = null;
            synchronized (borderTile) {
                copy = borderTile.copy(android.graphics.Bitmap.Config.ALPHA_8, true);
            }
            Canvas canvas = new Canvas(copy);
            String tileCoords = "(" + x + ", " + y + ")";
            String zoomLevel = "zoom = " + zoom;
            /* Paint is not thread safe. */
            Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mTextPaint.setTextAlign(Paint.Align.CENTER);
            mTextPaint.setTextSize(18 * scaleFactor);
            canvas.drawText(tileCoords, TILE_SIZE_DP * scaleFactor / 2,
                    TILE_SIZE_DP * scaleFactor / 2, mTextPaint);
            canvas.drawText(zoomLevel, TILE_SIZE_DP * scaleFactor / 2,
                    TILE_SIZE_DP * scaleFactor * 2 / 3, mTextPaint);
            return copy;
        }

    }

}