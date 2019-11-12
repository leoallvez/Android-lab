package br.com.lab.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import br.com.lab.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initElements()
    }

    private fun initElements() {
        //Getting the Navigation Controller
        navController = findNavController(this, R.id.fragment)
        //Setting the navigation controller to Bottom Nav
        bottom_nav.setupWithNavController(navController)
        //Setting up the action bar
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    //Setting Up the back button
    override fun onSupportNavigateUp() = NavigationUI.navigateUp(navController,null)
}
