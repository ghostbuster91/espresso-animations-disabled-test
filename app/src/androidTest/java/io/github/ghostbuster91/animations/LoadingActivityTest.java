package io.github.ghostbuster91.animations;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoadingActivityTest {

    @Rule
    public ActivityTestRule<LoadingActivity> rule = new ActivityTestRule<>(LoadingActivity.class);

    @Test
    public void assertLoaderIsVisible() {
        Espresso.onView(ViewMatchers.withId(R.id.progressBar)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
