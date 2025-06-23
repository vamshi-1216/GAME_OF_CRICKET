package com.example.game_of_cricket.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.game_of_cricket.R;

import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.example.game_of_cricket.adapters.TeamCreationPagerAdapter;


public class TeamCreationActivity extends AppCompatActivity{
    // This activity will handle team creation logic
    // You can implement the UI and functionality for creating teams here
    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    private TeamCreationPagerAdapter pagerAdapter; // Assuming you have a pager adapter for team creation


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_creation);

        // Initialize views
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        // Set up ViewPager2 with a PagerAdapter
        pagerAdapter = new TeamCreationPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        // Connect TabLayout with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {
                tab.setText("Team " + (position + 1));
            }
        }).attach();

    }

    // Add methods to handle team creation logic, such as saving teams to the database
}
