package com.ncorti.kotlin.template.library.android

import android.app.Application
import io.mockk.mockk
import org.junit.Assert.assertSame
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test

class AppContextTest {

    private lateinit var mockContext: Application
    private lateinit var appContext: AppContext

    @Before
    fun setUp() {
        mockContext = mockk()
        appContext = AppContext()
    }

    @Test
    fun `init should initialize context successfully`() {
        appContext.init(mockContext)
        appContext.getInstance()
        assertSame(mockContext, appContext.context)
    }

    @Test
    fun `getInstance should throw if not initialized`() {
        assertThrows(IllegalStateException::class.java) {
            appContext.getInstance()
        }.also {
            assertSame("AppContext must be initialized before getInstance", it.message)
        }
    }
}
