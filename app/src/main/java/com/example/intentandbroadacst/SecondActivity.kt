package com.example.intentandbroadacst

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentandbroadacst.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getData()

    }

    private fun getData(){
        val tvUname = binding.tvUsername
        val tvPass = binding.tvPassword

        val getUname = intent.getStringExtra("Username")
        val getPass = intent.getStringExtra("Password")

        tvUname.text = "Username: $getUname"
        tvPass.text = "Password: $getPass"

        binding.btnSearchName.setOnClickListener {
            val uri = Uri.parse("https://www.google.com/search?q=$getUname")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }



}