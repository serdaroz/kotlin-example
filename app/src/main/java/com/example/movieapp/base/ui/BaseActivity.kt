package com.example.movieapp.base.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    fun openActivity(intent: Intent, enterAnim: Int = 0, exitAnim: Int = 0) {
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
        overridePendingTransition(enterAnim, exitAnim)
    }

}