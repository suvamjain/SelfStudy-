package com.suvamjain.selfstudy.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.suvamjain.selfstudy.fragment.ScreenSlidePageFragment;

import java.util.ArrayList;

/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 */
public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> fragmentList;

    public ScreenSlidePagerAdapter(ArrayList<Fragment> fragmentList, FragmentManager fm) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        if (position >= 0 && position < fragmentList.size())
            return fragmentList.get(position);
        return new ScreenSlidePageFragment();
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
