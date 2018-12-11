package com.android.bug.bundle

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory
import okhttp3.OkHttpClient

class BundleApplication : Application() {
  override fun onCreate() {
    super.onCreate()

    val imagePipelineConfig = OkHttpImagePipelineConfigFactory
        .newBuilder(this, OkHttpClient())
        .build()
    Fresco.initialize(this, imagePipelineConfig)
  }
}