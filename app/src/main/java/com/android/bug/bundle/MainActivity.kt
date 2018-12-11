package com.android.bug.bundle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.bug.bundleerror.R

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
}
