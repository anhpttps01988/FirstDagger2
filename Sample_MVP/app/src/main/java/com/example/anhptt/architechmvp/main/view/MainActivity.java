package com.example.anhptt.architechmvp.main.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.anhptt.architechmvp.R;
import com.example.anhptt.architechmvp.common.activity.BaseActivity;
import com.example.anhptt.architechmvp.login.pojo.User;
import com.example.anhptt.architechmvp.main.MainActivityContract;
import com.example.anhptt.architechmvp.main.adapter.UserAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainActivityContract.View {

    @Inject
    MainActivityContract.Presenter mPresenter;
    @BindView(R.id.list_item)
    ListView lvUser;
    @BindView(R.id.progressBar2)
    ProgressBar proBar;

    private UserAdapter mUserAdapter;
    private List<User> mUserList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews(toolbar);
        setupListView();
    }

    private void setupListView() {
        mPresenter.getUserList();
        mUserAdapter = new UserAdapter(this,0, mUserList);
        lvUser.setAdapter(mUserAdapter);
    }

    private void initViews(Toolbar toolbar) {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.stop();
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void setPresenter(MainActivityContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showUserList(List<User> userList) {
        mUserList.clear();
        mUserList.addAll(userList);
    }

    @Override
    public void showUserListError() {
        proBar.setVisibility(View.GONE);
    }

    @Override
    public void showOpenLoading() {
        proBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCloseLoading() {
        proBar.setVisibility(View.GONE);
    }
}
