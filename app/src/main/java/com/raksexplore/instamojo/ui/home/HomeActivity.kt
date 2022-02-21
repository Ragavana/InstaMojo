package com.raksexplore.instamojo.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.raksexplore.instamojo.R
import com.raksexplore.instamojo.SectionsPagerAdapter
import com.raksexplore.instamojo.meow.bottomnavigation.MeowBottomNavigation
import com.raksexplore.instamojo.ui.like.LikeActivity
import com.raksexplore.instamojo.ui.profile.ProfileActivity
import com.raksexplore.instamojo.ui.search.SearchActivity
import com.raksexplore.instamojo.ui.share.ShareActivity
import com.raksexplore.instamojo.utils.BottomNavigationViewHelper


class HomeActivity : AppCompatActivity() {
    private var bottomNavigationViewEx: MeowBottomNavigation? = null
    private val TAG = "HomeActivity"
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
        bottomNavigationViewEx!!.setOnShowListener {
            model: MeowBottomNavigation.Model -> loadActivity(model)
        }
    }

    private fun loadActivity(model: MeowBottomNavigation.Model) {
        when (model.id) {
            1 -> {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
            2 -> {
                val intent = Intent(this, SearchActivity::class.java)
                startActivity(intent)
            }
            3 -> {
                val intent = Intent(this, ShareActivity::class.java)
                startActivity(intent)
            }
            4 -> {
                val intent = Intent(this, LikeActivity::class.java)
                startActivity(intent)
            }
            5 -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }
            else -> {
                null
            }
        }
    }
}