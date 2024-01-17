package com.ncorti.kotlin.template.library.android

import android.app.Application
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertSame
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppContextInstrumentedTest {

    @Test
    fun applicationContextVariableShouldMatchAppContext() {
        val expectedContext = InstrumentationRegistry.getInstrumentation().context.applicationContext

        // initialized by AppContextInitializer
        assertSame(expectedContext as Application, applicationContext)
    }
}
