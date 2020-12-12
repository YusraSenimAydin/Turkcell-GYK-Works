package com.example.ysrasenmdede.gyk401.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.ysrasenmdede.gyk401.R;
import com.example.ysrasenmdede.gyk401.fragments.DietListFragment;
import com.example.ysrasenmdede.gyk401.fragments.HealthFragment;
import com.example.ysrasenmdede.gyk401.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity   {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      BottomNavigationView navigation=(BottomNavigationView)findViewById(R.id.bottomNagivation);
        navigation.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) mOnNavigationItemSelectedListener);
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout,null);


    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment SelectedFragment=null;
            switch (item.getItemId()){
                case R.id.navigation_home:
                    SelectedFragment =new HomeFragment();
                    break;
                case R.id.navigation_health:
                    SelectedFragment =new HealthFragment();
                    break;
                case R.id.navigation_diet:
                    SelectedFragment =new DietListFragment();
                    break;

            }
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout,SelectedFragment);
            transaction.commit();
           return true;

        }
    };


}
