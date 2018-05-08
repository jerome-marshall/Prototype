package com.zero.jeromemarshall.prototype;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class HomepageActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        drawerLayout = (DrawerLayout) findViewById(R.id.homepage);
        toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        NavigationView nvDrawer = (NavigationView) findViewById(R.id.navigation_view);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nvDrawer);
    }

    public void selectItemDrawer(MenuItem menuItem) {
        Fragment fragment = null;
        Class FragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.dashboard:
                FragmentClass = DashboardFragment.class;
                break;
            case R.id.home:
                FragmentClass = HomeFragment.class;
                break;
            case R.id.profile:
                FragmentClass = ProfileFragment.class;
                break;
            case R.id.activities:
                FragmentClass = ActivitiesFragment.class;
                break;
            case R.id.settings:
                FragmentClass = SettingsFragment.class;
                break;
            case R.id.logout:
                FragmentClass = LogoutFragment.class;
                break;
            default:
                FragmentClass = HomeFragment.class;
                break;
        }
        try {
            fragment = (Fragment) FragmentClass.newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        drawerLayout.closeDrawers();
    }
    private  void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return true;
            }
        });
    }
}
