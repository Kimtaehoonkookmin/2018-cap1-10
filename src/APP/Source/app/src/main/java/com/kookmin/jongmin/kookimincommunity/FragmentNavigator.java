package com.kookmin.jongmin.kookimincommunity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by JongMin on 2018-02-19.
 */

public class FragmentNavigator {

    public static void replaceFragment(Activity activity, int parentLayoutId, Fragment targetFragment) {
        FragmentTransaction fragmentTransaction = activity.getFragmentManager().beginTransaction();
        fragmentTransaction.replace(parentLayoutId, targetFragment);
        fragmentTransaction.commit();
    }
    public static void replaceFragment(Activity activity, int parentLayoutId, Fragment targetFragment, String tag) {
        FragmentTransaction fragmentTransaction = activity.getFragmentManager().beginTransaction();
        fragmentTransaction.replace(parentLayoutId, targetFragment, tag);
        fragmentTransaction.commit();
    }
}
