package com.example.helloworldauto

import android.content.ComponentName
import android.content.Intent
import androidx.car.app.testing.SessionController
import androidx.car.app.testing.TestCarContext
import androidx.car.app.testing.TestScreenManager
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.internal.DoNotInstrument

@RunWith(RobolectricTestRunner::class)
@DoNotInstrument
class HelloWorldSessionTest {
  private val mTestCarContext =
    TestCarContext.createCarContext(ApplicationProvider.getApplicationContext())

  @Test
  fun onCreateScreen_returnsExpectedScreen() {
    val service = Robolectric.setupService(HelloWorldService::class.java)
    val session = service.onCreateSession()
    val controller = SessionController(
      session,
      mTestCarContext,
      Intent().setComponent(ComponentName(mTestCarContext, HelloWorldService::class.java))
    )
    controller.moveToState(Lifecycle.State.CREATED)
    val screenCreated =
      mTestCarContext.getCarService(TestScreenManager::class.java).screensPushed[0]
    assertThat(screenCreated).isInstanceOf(HelloWorldScreen::class.java)
  }
}