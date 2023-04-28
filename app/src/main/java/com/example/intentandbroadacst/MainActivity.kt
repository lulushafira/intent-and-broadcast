package com.example.intentandbroadacst

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentandbroadacst.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        sendData()
        moveApp()
        sendBroadcast()
    }

    private fun sendData(){
        binding.btnSendData.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("Username", binding.etUsername.text.toString())
            intent.putExtra("Password", binding.etPassword.text.toString())
            startActivity(intent)
        }
    }

    private fun moveApp(){
        binding.btnMoveApp.setOnClickListener {
            val intent = Intent()
            intent.action = "com.example.intentapp"
            startActivity(intent)
        }
    }

    private fun sendBroadcast(){
        binding.btnBroadcast.setOnClickListener {
            val intent = Intent()
            intent.action = "com.example.myBroadcast"
            intent.putExtra("broadcast_message", "Broadcast has been sent")
            sendBroadcast(intent)
        }
    }



}