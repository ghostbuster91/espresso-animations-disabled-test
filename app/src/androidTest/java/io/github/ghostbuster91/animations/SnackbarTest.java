package io.github.ghostbuster91.animations;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

public class SnackbarTest {

    @Rule
    public ActivityTestRule<SnackbarActivity> rule = new ActivityTestRule<>(SnackbarActivity.class);

    @Test
    public void assertSnackbarEffectiveVisibility() throws Exception {
        Espresso.onView(ViewMatchers.withText("here i am")).check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void assertSnackbarIsDisplayed() throws Exception {
        Espresso.onView(ViewMatchers.withText("here i am")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void assertSnackbarActionIsClickable() throws Exception {
        Espresso.onView(ViewMatchers.withText("Click")).perform(ViewActions.click());
    }
}
