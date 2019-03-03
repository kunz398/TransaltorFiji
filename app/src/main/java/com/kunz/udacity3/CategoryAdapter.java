package com.kunz.udacity3;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/**
 * Created by kunz on 12/2/2016.
 */

public class CategoryAdapter  extends FragmentPagerAdapter {

    private Context mContext;

            public CategoryAdapter(Context context,FragmentManager fm) {
            super(fm);
                mContext = context;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new NumberFragment();
            } else if (position == 1){
                return new ColorFragment();
            }else if(position==2){
                return new FamilyFragment();
            }else {
                return new PhrasesFragmanet();
            }
        }

        @Override
        public int getCount() {
            return 4;
        }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_numbers);
        } else if (position == 1) {
            return mContext.getString(R.string.category_colors);
        } else if (position == 2) {
            return mContext.getString(R.string.category_family);
        } else {
            return mContext.getString(R.string.category_phrases);
        }
    }
}