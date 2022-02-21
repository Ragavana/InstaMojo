package com.raksexplore.instamojo.ui.profile

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.raksexplore.instamojo.R
import com.raksexplore.instamojo.bottomnavigationviewex.BottomNavigationViewEx
import com.raksexplore.instamojo.utils.BottomNavigationViewHelper


class ProfileActivity : AppCompatActivity() {
    private var bottomNavigationViewEx: BottomNavigationViewEx? = null
    private val TAG = "HomeActivity"
    private val ACTIVITY_NUM = 4
    var mContext: Context = this@ProfileActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        Log.d(TAG, "onCreate: starting.")
        setupBottomNavigationView()
        setupToolbar()
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
    private fun setupToolbar() {
        val toolbar: Toolbar = findViewById<View>(R.id.profileToolBar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar.setOnMenuItemClickListener { item ->
            Log.d(TAG, "onMenuItemClick: clicked menu item: $item")
            when (item.itemId) {
                R.id.profileMenu -> Log.d(
                    TAG,
                    "onMenuItemClick: Navigating to Profile Preferences."
                )
            }
            false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile_menu, menu);
        return true;
    }
}