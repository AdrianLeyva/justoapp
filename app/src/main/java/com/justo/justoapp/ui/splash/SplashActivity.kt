package com.justo.justoapp.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.justo.justoapp.databinding.SplashActivityBinding
import com.justo.justoapp.ui.randomlist.RandomListActivity
import java.util.*

/**
 * @author adrianleyvasanchez
 * @since 7/24/21
 */
class SplashActivity : AppCompatActivity(){

    lateinit var binding: SplashActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        fetchAndLoad()
    }

    private fun fetchAndLoad() {
        // Usually used to download data and prepare it for main screen
        val intent = Intent(this, RandomListActivity::class.java)
        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity(intent)
            }
        }, 1500)
    }
}