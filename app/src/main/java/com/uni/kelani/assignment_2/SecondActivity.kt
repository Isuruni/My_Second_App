package com.uni.kelani.assignment_2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uni.kelani.assignment_2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayData()
    }



    private fun displayData(){
        val sharedPreferences = getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)
        val savedName = sharedPreferences.getString("nameKey", null)
        val savedEmail = sharedPreferences.getString("emailKey", null)
        val savedAddress = sharedPreferences.getString("addressKey", null)
        val savedBoolean = sharedPreferences.getBoolean("booleanKey", false)
        if(savedBoolean){
            binding.textView_Six.setText("Welcome as a student")
        }
        else{
            binding.textView_Six.setText("Welcome as a non-student")
        }

        binding.textView_Second.setText(savedName)
        binding.textView_Fourth.setText(savedEmail)
        binding.textView_Fifth.setText(savedAddress)

    }
}