package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MovieDetailsActivity extends AppCompatActivity {
    private NavigationDrawerDelegate navDrawerDelegate;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toast.makeText(this,"Detail activity has been called!", Toast.LENGTH_SHORT).show();

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

        // Set up navigation drawer and toolbar
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationView navView = findViewById(R.id.nav_view);
        navDrawerDelegate = new NavigationDrawerDelegate(this, drawerLayout, toolbar, navView);
        navDrawerDelegate.setupNavDrawer();

        // Calculate number of columns to determine spanCount for GridLayoutManager()
        int noOfColumns = getResources().getInteger(R.integer.numberOfColumnsForGridView);

        RecyclerView mRecyclerView = findViewById(R.id.my_recycler_view);

        // Using this setting if changes in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // Specify an adapter
        adapter = new MyAdapter();
        mRecyclerView.setAdapter(adapter);

        // Grid layout manager
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, noOfColumns);
        mRecyclerView.setLayoutManager(gridLayoutManager);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return navDrawerDelegate.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

}