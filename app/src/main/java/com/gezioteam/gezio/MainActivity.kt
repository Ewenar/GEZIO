package com.gezioteam.gezio;


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.gezioteam.gezio.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val profilebutton = findViewById<ImageButton>(R.id.toolbar_profile)
        profilebutton.setOnClickListener{
            openProfileActivity()
        }


        setSupportActionBar(binding.toolbar)
        val toggle = ActionBarDrawerToggle(this,binding.drawerLayout,binding.toolbar,R.string.nav_open,R.string.nav_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationDrawer.setNavigationItemSelectedListener ( this)
        binding.bottomNavigation.background=null
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.bottom_home -> openFragment(HomeFragment())
                R.id.bottom_schedule -> openFragment(ScheduleFragment())
                R.id.bottom_favorite -> openFragment(FavoriteFragment())
                R.id.bottom_search -> openFragment(SearchFragment())
            }
            true
        }

        fragmentManager=supportFragmentManager
        openFragment(HomeFragment())

        binding.fab.setOnClickListener{
            Toast.makeText(this,"Select Location",Toast.LENGTH_SHORT).show()
            openLocationActivity()
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home ->openFragment(HomeFragment())
            R.id.nav_schedule ->openFragment(ScheduleFragment())
            R.id.nav_favorite ->openFragment(FavoriteFragment())
            R.id.nav_search -> openFragment(SearchFragment())
            R.id.nav_location -> openLocationActivity()
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.getOnBackPressedDispatcher().onBackPressed()
        }
    }

    private fun openFragment(fragment: Fragment){
        val fragmentTransaction: FragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()

    }

    fun openProfileActivity() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }
    fun openLocationActivity() {
        val intent = Intent(this, LocationActivity::class.java)
        startActivity(intent)
    }

}
