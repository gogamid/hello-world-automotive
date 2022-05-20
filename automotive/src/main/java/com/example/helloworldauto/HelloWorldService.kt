package com.example.helloworldauto

import android.content.Intent
import android.content.pm.ApplicationInfo
import androidx.car.app.CarAppService
import androidx.car.app.R
import androidx.car.app.Screen
import androidx.car.app.Session
import androidx.car.app.validation.HostValidator

class HelloWorldService : CarAppService() {
  override fun createHostValidator(): HostValidator {
    return if (applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0) {
      HostValidator.ALLOW_ALL_HOSTS_VALIDATOR
    } else HostValidator.Builder(applicationContext)
      .addAllowedHosts(R.array.hosts_allowlist_sample)
      .build()
  }

  override fun onCreateSession(): Session {
    return object : Session() {
      override fun onCreateScreen(intent: Intent): Screen {
        return HelloWorldScreen(carContext)
      }
    }
  }
}