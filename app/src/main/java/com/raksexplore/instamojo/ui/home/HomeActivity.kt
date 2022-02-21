package com.raksexplore.instamojo.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.raksexplore.instamojo.R
import com.raksexplore.instamojo.SectionsPagerAdapter
import com.raksexplore.instamojo.bottomnavigationviewex.BottomNavigationViewEx
import com.raksexplore.instamojo.utils.BottomNavigationViewHelper


class HomeActivity : AppCompatActivity() {
    var mContext:Context = this@HomeActivity
    private var bottomNavigationViewEx: BottomNavigationViewEx? = null
    private val TAG = "HomeActivity"
    private val ACTIVITY_NUM = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Log.d(TAG, "onCreate: starting.")
        setupBottomNavigationView()
        setupViewPager()


    }

    private fun setupViewPager() {
        val adapter = SectionsPagerAdapter(supportFragmentManager)
        adapter.addFragment(CameraFragment()) //index 0

        adapter.addFragment(HomeFragment()) //index 1

        adapter.addFragment(ChatFragment()) //index 2

        val viewPager = findViewById<View>(R.id.container) as ViewPager
        viewPager.adapter = adapter

        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_camera)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_house)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_arrow)
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