package com.facci.proyecto.aplicacionmovil;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

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

        /*TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Chats"));
        tabs.addTab(tabs.newTab().setText("Grupos"));
        tabs.addTab(tabs.newTab().setText("Contactos"));*/
    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new contactoFragment(), "Contactos");
        viewPager.setAdapter(adapter);
    }

}
