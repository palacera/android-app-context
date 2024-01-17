package com.ncorti.kotlin.template.library.android

import android.app.Application
import android.content.Context
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

internal class AppContextInitializerTest {

    private lateinit var mockContext: Context
    private lateinit var mockApplicationContext: Application
    private lateinit var appContextInitializer: AppContextInitializer

    @Before
    fun setUp() {
        mockContext = mockk()
        mockApplicationContext = mockk<Application>()
        every { mockContext.applicationContext } returns mockApplicationContext
        appContextInitializer = AppContextInitializer()
    }

    @Test
    fun `create initializes AppContext with applicationContext`() {
        val appContext = appContextInitializer.create(mockContext)

        val appContextInstance = appContext.getInstance()
        val actualContext = appContextInstance.context

        assertSame(mockApplicationContext, actualContext)
    }

    @Test
    fun `dependencies returns empty list`() {
        val dependencies = appContextInitializer.dependencies()

        assertTrue(dependencies.isEmpty())
    }
}
