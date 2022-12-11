package com.sarkartech.androidnavigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout);
        val navView: NavigationView = findViewById(R.id.nav_View);

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.mHome -> Toast.makeText(applicationContext, "Clicked Home", Toast.LENGTH_SHORT)
                    .show()
                R.id.mShare -> Toast.makeText(
                    applicationContext, "Clicked Share", Toast.LENGTH_SHORT
                ).show()
                R.id.mDashboard -> Toast.makeText(
                    applicationContext, "Clicked Dashboard", Toast.LENGTH_SHORT
                ).show()
                R.id.mRate -> Toast.makeText(applicationContext, "Clicked Rate", Toast.LENGTH_SHORT)
                    .show()
                R.id.mPolicy -> Toast.makeText(
                    applicationContext, "Clicked Policy", Toast.LENGTH_SHORT
                ).show()
            }

            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}