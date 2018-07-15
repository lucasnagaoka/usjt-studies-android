package com.example.arqdsis.viewpagercomfragmentsccp3anmca;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;

/**
 * Created by arqdsis on 18/04/2018.
 */

public class FragmentListener implements ActionBar.TabListener {
    private ViewPager viewPager;
    private int index;

    public FragmentListener(ViewPager viewPager, int index) {
        this.viewPager = viewPager;
        this.index = index;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(index);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
