package com.example.navdrawer;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;

/*All activities inherits this class*/

public class MenuActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //The very root
        setContentView(R.layout.activity_menu);
        //where the rootview drawerlayout is declared
        mDrawerLayout = findViewById(R.id.drawer_layout);
        //toolbar at top
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*This class provides a handy way to tie together the functionality of DrawerLayout and the framework ActionBar to implement the
recommended design for navigation drawers. This drawable shows a Hamburger icon when drawer is closed and an arrow when drawer is open.
String resources must be provided to describe the open/close drawer actions for accessibility services.*/
ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);
drawerToggle.syncState();




        //declared in the DrawerLayout activity_menu.xml
        NavigationView navigationView = findViewById(R.id.nav_view);

        //It has a menu attribute
        //  app:menu="@menu/drawer_view"

        navigationView.setNavigationItemSelectedListener(

                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        //from menu/drawer_view.xml
                        switch (menuItem.getItemId()) {
                            case R.id.nav_home:
                                home();
                                return true;

                                case R.id.nav_first:
                                    startFirstActivity();
                                    return true;

                            case R.id.nav_second:
                                startSecondActivity();
                                return true;
                        }




                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();


                        return true;
                    }
                });
    }



    //Märker att du klickat på meneyn
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if (item.getItemId() == android.R.id.home) {

            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void startFirstActivity(){
        Intent intent = new Intent(this, FirstActivity.class);

        startActivity(intent);
    }
    private void startSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    private void home() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
