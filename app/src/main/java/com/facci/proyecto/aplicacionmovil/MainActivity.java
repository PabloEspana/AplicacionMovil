package com.facci.proyecto.aplicacionmovil;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by Pablo on 11/4/2018.
 */

public class MainActivity extends AppCompatActivity {

    private SectionsPageAdapter sPageAdapter;
    private ViewPager vP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        vP = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(vP);

        // Adding Toolbar to Main screen
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(vP);



    }

    public void verDispositivos(View v) {
        Intent intent = new Intent(MainActivity.this, dispositivosActivity.class);
        startActivity(intent);
    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new chatsFragment(), "Chats");
        adapter.addFragment(new gruposFragment(), "Grupos");
        adapter.addFragment(new contactoFragment(), "Contactos");
        viewPager.setAdapter(adapter);
    }

}
