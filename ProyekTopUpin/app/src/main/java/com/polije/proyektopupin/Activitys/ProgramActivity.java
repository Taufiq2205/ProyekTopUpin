package com.polije.proyektopupin.Activitys;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.polije.proyektopupin.Fragment.HistoryFragment;
import com.polije.proyektopupin.Fragment.HomeFragment;
import com.polije.proyektopupin.Fragment.ProfileFragment;
import com.polije.proyektopupin.Fragment.ShopFragment;
import com.polije.proyektopupin.R;

public class ProgramActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_program);

        if(getSupportActionBar() !=null){
            getSupportActionBar().hide();
        }

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    HomeFragment homeFragment = new HomeFragment();
    ShopFragment shopFragment = new ShopFragment();
    HistoryFragment historyFragment = new HistoryFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.home) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, homeFragment)
                    .commit();
            return true;
        } else if (itemId == R.id.shop) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, shopFragment)
                    .commit();
            return true;
        } else if (itemId == R.id.history) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, historyFragment)
                    .commit();
            return true;
        } else if (itemId == R.id.profile) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, profileFragment)
                    .commit();
            return true;
        } else {
            return false;
        }
    }
}