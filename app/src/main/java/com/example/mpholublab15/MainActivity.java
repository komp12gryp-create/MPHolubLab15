package com.example.mpholublab15;

import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TabHost tabHost = findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec(getString(R.string.tab_studies));
        tabSpec.setContent(R.id.studies);
        tabSpec.setIndicator(getString(R.string.tab_studies));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec(getString(R.string.tab_hobbies));
        tabSpec.setContent(R.id.hobbies);
        tabSpec.setIndicator(getString(R.string.tab_hobbies));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec(getString(R.string.tab_about_me));
        tabSpec.setContent(R.id.about_me);
        tabSpec.setIndicator(getString(R.string.tab_about_me));
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Toast.makeText(MainActivity.this, tabId, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
