package name.kocian.clean.presentation.screen.home

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import name.kocian.clean.R
import name.kocian.clean.presentation.base.MockWebServerRule
import name.kocian.clean.presentation.base.UiTest
import name.kocian.clean.presentation.ui.sample.MainActivity
import okhttp3.mockwebserver.MockResponse
import org.junit.Rule

@Suppress("ClassName")
open class HomeDefinitions(feature: String, description: String)
    : UiTest(feature, description) {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Rule
    @JvmField
    val mockWebServerRule = MockWebServerRule()

    companion object {
        val responseText = "Clean Architecture"
    }

    class Given {
        object server {
            fun willRespondWithSampleData() {
                MockWebServerRule.server.enqueue(MockResponse().setBody("[{\"name\": \"$responseText\"}]"))
            }
        }

        object user {
            fun hasOpenedHomeScreen() {
                Thread.sleep(50)
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
                onView(withId(R.id.welcome)).check(matches(withText(responseText)))
            }
        }
    }
}
