package com.uni.kelani.assignment_2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.uni.kelani.assignment_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //val navController = findNavController(R.id.nav_host_fragment_content_main)
        //appBarConfiguration = AppBarConfiguration(navController.graph)
        //setupActionBarWithNavController(navController, appBarConfiguration)

        binding.buttonFirst.setOnClickListener { view ->
            saveData()
            this.goToSecondActivity()
        }
    }

    private fun goToSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    private fun saveData(){
        val insertedName = binding.editTextFirst.text.toString()
        val insertedEmail = binding.editTextSecond.text.toString()
        val insertedAddress = binding.editTextThird.text.toString()
        val insertedBoolean = binding.switch1.isChecked
        val sharedPreferences = getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("nameKey", insertedName)
            putString("emailKey", insertedEmail)
            putString("addressKey", insertedAddress)
            putBoolean("booleanKey", insertedBoolean)

        }.apply()

        Toast.makeText(this, "Your information is saved", Toast.LENGTH_SHORT).show()

    }

}