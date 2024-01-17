package com.ncorti.kotlin.template.library.android

import android.app.Application
import android.content.Context

val applicationContext: Application by lazy { AppContext.getInstance().context }

internal class AppContext {
    lateinit var context: Application
        private set

    fun init(context: Context) {
        if (!::context.isInitialized) {
            this.context = context as Application
        }
    }

    fun getInstance(): AppContext {
        if (!::context.isInitialized) {
            throw IllegalStateException("AppContext must be initialized before getInstance")
        }
        return this
    }

    companion object {
        private val appContext: AppContext = AppContext()
        fun init(context: Context) = appContext.init(context)
        fun getInstance(): AppContext = appContext.getInstance()
    }
}
