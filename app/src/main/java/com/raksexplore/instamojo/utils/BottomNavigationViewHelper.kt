package com.raksexplore.instamojo.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.raksexplore.instamojo.R
import com.raksexplore.instamojo.bottomnavigationviewex.BottomNavigationViewEx
import com.raksexplore.instamojo.ui.home.HomeActivity
import com.raksexplore.instamojo.ui.like.LikeActivity
import com.raksexplore.instamojo.ui.profile.ProfileActivity
import com.raksexplore.instamojo.ui.search.SearchActivity
import com.raksexplore.instamojo.ui.share.ShareActivity


class BottomNavigationViewHelper {

    private val TAG = "BottomNavigationViewHel"

    fun setupBottomNavigationView(bottomNavigationViewEx: BottomNavigationViewEx) {
        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavigationView")
        bottomNavigationViewEx.enableAnimation(false)
        bottomNavigationViewEx.enableItemShiftingMode(false)
        bottomNavigationViewEx.enableShiftingMode(false)
        bottomNavigationViewEx.setTextVisibility(false)
    }

    fun enableNavigation(
        context: Context,
        callingActivity: Activity,
        view: BottomNavigationViewEx
    ) {
        view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.ic_house -> {
                    val intent1 = Intent(context, HomeActivity::class.java) //ACTIVITY_NUM = 0
                    context.startActivity(intent1)
                    callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                }
                R.id.ic_search -> {
                    val intent2 = Intent(context, SearchActivity::class.java) //ACTIVITY_NUM = 1
                    context.startActivity(intent2)
                    callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                }
                R.id.ic_circle -> {
                    val intent3 = Intent(context, ShareActivity::class.java) //ACTIVITY_NUM = 2
                    context.startActivity(intent3)
                    callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                }
                R.id.ic_alert -> {
                    val intent4 = Intent(context, LikeActivity::class.java) //ACTIVITY_NUM = 3
                    context.startActivity(intent4)
                    callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                }
                R.id.ic_android -> {
                    val intent5 = Intent(context, ProfileActivity::class.java) //ACTIVITY_NUM = 4
                    context.startActivity(intent5)
                    callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                }
            }
            false
        }
    }

}