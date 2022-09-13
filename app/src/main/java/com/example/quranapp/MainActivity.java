package com.example.quranapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    DBHelper db;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(getApplicationContext(),"Start",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(getApplicationContext(),"End",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView=findViewById(R.id.nav_view);
        drawerLayout=findViewById(R.id.drawer_Layout);


        DBHelper db = new DBHelper(getApplicationContext());




        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_home:
                        Toast.makeText(getApplicationContext(),"Home Clicked",Toast.LENGTH_LONG).show();
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_surah:
                        Toast.makeText(getApplicationContext(),"Surah Information Clicked",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, surahList.class);
                        startActivity(intent);
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_fmj :
                        Intent trans1 = new Intent(MainActivity.this, translationMain.class);
                        trans1.putExtra("translationId", 1);
                        startActivity(trans1);
                        break;

                    case R.id.nav_mh :
                        Intent trans2 = new Intent(MainActivity.this, translationMain.class);
                        trans2.putExtra("translationId", 2);
                        startActivity(trans2);
                        break;

                    case R.id.nav_dmk :
                        Intent trans3 = new Intent(MainActivity.this, translationMain.class);
                        trans3.putExtra("translationId", 3);
                        startActivity(trans3);
                        break;

                    case R.id.nav_mtu:
                        Intent trans4 = new Intent(MainActivity.this, translationMain.class);
                        trans4.putExtra("translationId", 4);
                        startActivity(trans4);
                        break;
                }

                return true;
            }
        });


    }

}