package name.kocian.clean.presentation.screen.home

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import name.kocian.clean.R
import name.kocian.clean.presentation.base.UiTest
import name.kocian.clean.presentation.ui.sample.MainActivity
import org.junit.Rule

open class HomeDefinitions(feature: String, description: String)
    : UiTest(feature, description) {

    @get:Rule
    @Suppress("unused")
    val activityRule = ActivityTestRule(MainActivity::class.java)

    class Given {
        object user {
            fun hasOpenedHomeScreen() {
                // TODO
            }
        }
    }

    class When {
        object user {
            fun isOnHomeScreen() {
                // TODO
            }
        }
    }

    class Then {
        object user {
            fun willSeeSampleText() {
                onView(withId(R.id.welcome)).check(matches(withText("test")))
            }
        }
    }
}
