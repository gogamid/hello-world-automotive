package com.example.helloworldauto

import androidx.car.app.model.PaneTemplate
import androidx.car.app.model.Row
import androidx.car.app.testing.TestCarContext
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.internal.DoNotInstrument

@RunWith(RobolectricTestRunner::class)
@DoNotInstrument
class HelloWorldScreenTest {
  val mTestCarContext = TestCarContext.createCarContext(ApplicationProvider.getApplicationContext())

  @Test
  fun getTemplate_containsExpectedRow() {
    val screen = HelloWorldScreen(mTestCarContext)
    val template = screen.onGetTemplate() as PaneTemplate
    val rows: List<Row> = template.pane.rows
    assertThat(rows).hasSize(1)
    assertThat(rows[0]).isEqualTo(Row.Builder().setTitle("Hello World Automotive OS").build())
  }
}