package com.raksexplore.instamojo.utils

import android.util.Log
import com.raksexplore.instamojo.R
import com.raksexplore.instamojo.meow.bottomnavigation.BezierView
import com.raksexplore.instamojo.meow.bottomnavigation.MeowBottomNavigation


class BottomNavigationViewHelper {

    private val TAG = "BottomNavigationViewHel"

    fun setupBottomNavigationView(bottomNavigationView: MeowBottomNavigation) {
        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavigationView")
        bottomNavigationView.add(MeowBottomNavigation.Model(1, R.drawable.ic_house))
        bottomNavigationView.add(MeowBottomNavigation.Model(2, R.drawable.ic_search))
        bottomNavigationView.add(MeowBottomNavigation.Model(3, R.drawable.ic_circle))
        bottomNavigationView.add(MeowBottomNavigation.Model(4, R.drawable.ic_alert))
        bottomNavigationView.add(MeowBottomNavigation.Model(5, R.drawable.ic_username))
    }
}