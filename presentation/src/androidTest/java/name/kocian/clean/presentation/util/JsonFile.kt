package name.kocian.clean.presentation.util

import android.support.test.InstrumentationRegistry

class JsonFile(val name: String) {

    fun load() = InstrumentationRegistry.getContext().assets.open(name).use {
        it.reader().readText()
    }
}
