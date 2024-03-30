package com.affan.cuwaca.presentation.splash_screen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.affan.cuwaca.R
import com.affan.cuwaca.presentation.GetStartedActivity
import com.affan.cuwaca.presentation.home_screen.view.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Handler untuk menunda beralih ke MainActivity selama 4 detik (4000 milidetik)
        Handler().postDelayed({
            val mainIntent = Intent(this, GetStartedActivity::class.java)
            startActivity(mainIntent)
            finish()
            // Menutup activity splash screen agar tidak bisa kembali lagi dengan menekan tombol back
        }, 2000) // Waktu delay dalam milidetik (4000 milidetik = 4 detik)
    }
}