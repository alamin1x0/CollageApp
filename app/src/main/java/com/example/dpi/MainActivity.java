package com.example.dpi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.dpi.navigation.developer.Developera;
import com.example.dpi.navigation.ebook.EbookActivity;
import com.example.dpi.navigation.video.VideoLacture;
import com.example.dpi.navigation.website.Websites;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private int checkedItem;
    private String selected;

    private final String CHECKEDITEM = "checked_item";

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("");

        //FirebaseMessaging.getInstance().subscribeToTopic("notification");

        auth = FirebaseAuth.getInstance();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this, R.id.frame_layout);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);


        NavigationUI.setupWithNavController(bottomNavigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {

            case R.id.navigation_videos:
                intent = new Intent(MainActivity.this, VideoLacture.class);
                startActivity(intent);
                break;

            case R.id.navigation_ebooks:
                intent = new Intent(MainActivity.this, EbookActivity.class);
                startActivity(intent);
                break;

            case R.id.navigation_websites:
                intent = new Intent(MainActivity.this, Websites.class);
                startActivity(intent);
                break;

            case R.id.navigation_developer:
                intent = new Intent(MainActivity.this, Developera.class);
                startActivity(intent);
                break;


        }

        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

}