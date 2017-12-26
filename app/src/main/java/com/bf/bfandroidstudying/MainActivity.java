package com.bf.bfandroidstudying;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import CusView.BFViewPager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void actionSubVPBtn(View view) {
//        Intent subVPIntent = new Intent(this, ViewPager.BFSubViewPagerActivity.class);
//        startActivity(subVPIntent);
    }

    public void actionFragmentStatePagerBtn(View view) {
        Intent fspIntent = new Intent(this, BFFragmentStatePagerActivity.class);
        startActivity(fspIntent);
    }
}
