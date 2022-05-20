package com.example.helloworldauto

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*

class HelloWorldScreen(carContext: CarContext) : Screen(carContext) {

  override fun onGetTemplate(): Template {
    val row = Row.Builder().setTitle("Hello World Automotive OS").build()
    return PaneTemplate.Builder(Pane.Builder().addRow(row).build())
      .setHeaderAction(Action.APP_ICON)
      .build()
  }
}
