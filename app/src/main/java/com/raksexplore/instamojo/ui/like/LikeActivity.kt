package com.raksexplore.instamojo.ui.like

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.raksexplore.instamojo.R
import com.raksexplore.instamojo.utils.BottomNavigationViewHelper
import com.raksexplore.instamojo.meow.bottomnavigation.MeowBottomNavigation
import com.raksexplore.instamojo.ui.home.HomeActivity
import com.raksexplore.instamojo.ui.profile.ProfileActivity
import com.raksexplore.instamojo.ui.search.SearchActivity
import com.raksexplore.instamojo.ui.share.ShareActivity


class LikeActivity : AppCompatActivity() {
    private var bottomNavigationViewEx: MeowBottomNavigation? = null
    private val TAG = "HomeActivity"
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