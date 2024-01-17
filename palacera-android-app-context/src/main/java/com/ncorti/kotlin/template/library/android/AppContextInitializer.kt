package com.ncorti.kotlin.template.library.android

import android.content.Context
import androidx.startup.Initializer

internal class AppContextInitializer : Initializer<AppContext> {
    override fun create(context: Context): AppContext {
        AppContext.init(context.applicationContext)
        return AppContext.getInstance()
    }
    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}
