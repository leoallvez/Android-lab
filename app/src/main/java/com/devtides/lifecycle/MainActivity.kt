package com.devtides.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.devtides.lifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Obtain the ViewModel component.
    private val viewModel: MyViewModel by lazy {
        ViewModelProviders.of(this).get(MyViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate view and obtain an instance of the binding class.
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // Specify the current activity as the lifecycle owner.
        binding.lifecycleOwner = this
        // Assign the component to a property in the binding class.
        binding.viewmodel = viewModel
    }
}
