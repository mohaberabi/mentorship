package com.mohaberabi.fragmentcommunication.usingactivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mohaberabi.fragmentcommunication.R
import com.mohaberabi.fragmentcommunication.ThemeShowerFragment

class ThemeChangerActivity : AppCompatActivity(), ThemeChangerAction {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_theme_changer)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun changeTheme(isDark: Boolean) {
        val changer =
            supportFragmentManager.findFragmentById(R.id.themeChangerFragment) as? ThemeChangerFragment
        changer?.changeTheme(isDark)
        val shower =
            supportFragmentManager.findFragmentById(R.id.themeShowerFragment) as? ThemeShowerFragment
        shower?.setTheme(isDark)
    }
}