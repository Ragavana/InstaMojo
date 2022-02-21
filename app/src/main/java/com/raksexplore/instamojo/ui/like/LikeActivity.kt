package com.raksexplore.instamojo.ui.like

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.raksexplore.instamojo.R
import com.raksexplore.instamojo.bottomnavigationviewex.BottomNavigationViewEx
import com.raksexplore.instamojo.ui.home.HomeActivity
import com.raksexplore.instamojo.ui.profile.ProfileActivity
import com.raksexplore.instamojo.ui.search.SearchActivity
import com.raksexplore.instamojo.ui.share.ShareActivity
import com.raksexplore.instamojo.utils.BottomNavigationViewHelper


class LikeActivity : AppCompatActivity() {
    private var bottomNavigationViewEx: BottomNavigationViewEx? = null
    private val TAG = "HomeActivity"
    private val ACTIVITY_NUM = 3
    var mContext: Context = this@LikeActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_like)
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