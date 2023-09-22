package com.recharge.nirbhay.rechargewallete.viewpagerindicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.recharge.nirbhay.rechargewallete.R;
import com.recharge.nirbhay.rechargewallete.viewpagerindicator.indicatorlibrary.IconPagerAdapter;


class TestFragmentAdapter extends FragmentPagerAdapter implements IconPagerAdapter {
    protected static final String[] CONTENT = new String[] {"first", "second", "threed", "four","five", };
    protected static final int[] ICONS = new int[] {
            R.drawable.sliderbanner,
            R.drawable.sliderbanner,
            R.drawable.sliderbanner,
            R.drawable.sliderbanner
    };

    private int mCount = CONTENT.length;

    public TestFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return TestFragmentAdapter.CONTENT[position % CONTENT.length];
    }

    @Override
    public int getIconResId(int index) {
      return ICONS[index % ICONS.length];
    }

    public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }
}