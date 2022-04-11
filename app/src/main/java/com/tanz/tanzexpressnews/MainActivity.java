package com.tanz.tanzexpressnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.Home);

    }
    HomeFragment firstFragment = new HomeFragment();
    HealthFragment secondFragment = new HealthFragment();
    ScienceFragment thirdFragment = new ScienceFragment();
    SportsFragment fourthFragment = new SportsFragment();
    EntertainmentFragment fifthFragment = new EntertainmentFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        new DrawerBuilder().withActivity(this).build();
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.drawer_item_home);
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName(R.string.drawer_item_settings);
        toolbar = findViewById(R.id.toolbar);
//create the drawer and remember the `Drawer` result object

        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,

                        item2,
                        new SecondaryDrawerItem().withName(R.string.drawer_item_home)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        return false;
                    }
                })
                .build();
        switch (item.getItemId()) {
            case R.id.Home:
                getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayoutFragment, firstFragment).commit();
                return true;

            case R.id.Health:
                getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayoutFragment, secondFragment).commit();
                return true;

            case R.id.Science:
                getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayoutFragment, thirdFragment).commit();
                return true;
            case R.id.Sports:
                getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayoutFragment, fourthFragment).commit();
                return true;
            case R.id.Entertainment:
            getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayoutFragment, fifthFragment).commit();
            return true;

        }
        return false;
    }
}
