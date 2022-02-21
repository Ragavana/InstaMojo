package com.raksexplore.instamojo.ui.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.raksexplore.instamojo.R
import com.raksexplore.instamojo.bottomnavigationviewex.BottomNavigationViewEx
import com.raksexplore.instamojo.utils.BottomNavigationViewHelper
import com.raksexplore.instamojo.meow.bottomnavigation.MeowBottomNavigation
import com.raksexplore.instamojo.ui.home.HomeActivity
import com.raksexplore.instamojo.ui.like.LikeActivity
import com.raksexplore.instamojo.ui.profile.ProfileActivity
import com.raksexplore.instamojo.ui.share.ShareActivity


class SearchActivity : AppCompatActivity() {
    private var bottomNavigationViewEx: BottomNavigationViewEx? = null
    private val TAG = "HomeActivity"
    private val ACTIVITY_NUM = 1
    var mContext: Context = this@SearchActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        Log.d(TAG, "onCreate: starting.")
        setupBottomNavigationView()


    }

    private fun setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView")
        bottomNavigationViewEx = findViewById(R.id.bottomNavViewBar)
        val bottomNavigationViewHelper = BottomNavigationViewHelper()
        bottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx!!)
        bottomNavigationViewHelper.enableNavigation(mContext, this, bottomNavigationViewEx!!)
        val menu: Menu = bottomNavigationViewEx!!.menu
        val menuItem: MenuItem = menu.getItem(ACTIVITY_NUM)
        menuItem.isChecked = true
    }
}