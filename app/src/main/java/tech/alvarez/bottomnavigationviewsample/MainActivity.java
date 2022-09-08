package tech.alvarez.bottomnavigationviewsample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import tech.alvarez.bottomnavigationviewsample.fragments.CameraFragment;
import tech.alvarez.bottomnavigationviewsample.fragments.FavoritesFragment;
import tech.alvarez.bottomnavigationviewsample.fragments.HomeFragment;
import tech.alvarez.bottomnavigationviewsample.fragments.ProfileFragment;
import tech.alvarez.bottomnavigationviewsample.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Fragment homeFragment = new HomeFragment();
        final Fragment searchFragment = new SearchFragment();
        final Fragment cameraFragment = new CameraFragment();
        final Fragment favoritesFragment = new FavoritesFragment();
        final Fragment profileFragment = new ProfileFragment();

        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer, homeFragment).commit();
        }

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            if (item.getItemId() == R.id.inicioItem) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, homeFragment).commit();
            } else if (item.getItemId() == R.id.buscarItem) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, searchFragment).commit();
            } else if (item.getItemId() == R.id.camaraItem) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, cameraFragment).commit();
            } else if (item.getItemId() == R.id.favoritosItem) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, favoritesFragment).commit();
            } else if (item.getItemId() == R.id.perfilItem) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, profileFragment).commit();
            }
            return true;
        });

        BadgeDrawable badge = bottomNavigationView.getOrCreateBadge(R.id.inicioItem);
        badge.setNumber(7);
        badge.setVisible(true);
    }
}
