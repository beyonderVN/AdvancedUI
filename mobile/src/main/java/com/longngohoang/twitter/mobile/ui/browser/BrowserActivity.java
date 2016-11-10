package com.longngohoang.twitter.mobile.ui.browser;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.longngohoang.twitter.mobile.R;
import com.longngohoang.twitter.mobile.ui.adapter.BaseAdapter;
import com.longngohoang.twitter.mobile.ui.adapter.viewmodel.BaseVM;
import com.longngohoang.twitter.mobile.ui.adapter.viewmodel.SectionVM;
import com.longngohoang.twitter.mobile.ui.adapter.viewmodel.SimpleVM;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.longngohoang.twitter.mobile.R.id.toolbar;


public class BrowserActivity extends AppCompatActivity {
    private static final String TAG = "BrowserActivity";

    @BindView(R.id.appbar)
    AppBarLayout mAppBar;
    @BindView(toolbar)
    Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;
    @BindView(R.id.rvSectionList)
    RecyclerView recyclerView;

    List<BaseVM> sectionList = new ArrayList<>();
    BaseAdapter baseAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupDrawable();
        createData();
        setupAdapter();
        setupRecyclerView();
    }


    private void createData() {
        for (int i = 0; i < 10; i++) {
            List<BaseVM> simpleVMs = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                simpleVMs.add(new SimpleVM());
            }
            sectionList.add(new SectionVM(String.valueOf(i),simpleVMs));
        }

    }
    private void setupAdapter() {
        baseAdapter = new BaseAdapter(this,sectionList);
    }


    private void setupDrawable() {
        setupToolbar(mDrawer);
    }
    ActionBarDrawerToggle toggle;
    private void setupToolbar(DrawerLayout drawer) {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        frameLayout = (FrameLayout) findViewById(R.id.flCover);

        mAppBar.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            boolean showTitle = (mCollapsingToolbar.getHeight() + verticalOffset) <= (mToolbar.getHeight()*2) ;
            Log.d(TAG, "verticalOffset: "+verticalOffset);
            frameLayout.setPadding(-verticalOffset/10,-verticalOffset/10,-verticalOffset/10,-verticalOffset/10);
            if(showTitle){
                mCollapsingToolbar.setTitle("Twitter");
            }else {
                mCollapsingToolbar.setTitle("");
            }

        });
    }
    FrameLayout frameLayout;
    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(baseAdapter);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        switch (id){
            case R.id.action_logout :
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    void showDailog(){
        Toast.makeText(this, "fab", Toast.LENGTH_SHORT).show();
    }
}
