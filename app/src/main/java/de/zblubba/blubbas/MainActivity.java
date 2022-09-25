package de.zblubba.blubbas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import de.zblubba.blubbas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    DashboardFragment dashboardFragment = new DashboardFragment();
    AccountFragment accountFragment = new AccountFragment();

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        replaceFragment(homeFragment);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch(item.getItemId()) {
                case R.id.home:
                    replaceFragment(homeFragment);
                    break;
                case R.id.dashboard:
                    replaceFragment(dashboardFragment);
                    break;
                case R.id.account:
                    replaceFragment(accountFragment);
                    break;
            }

            return true;
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}