package com.mytaxi.android_demo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class LoginTest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkFailedLogin() {
        onView(withId(R.id.edt_username))
                .perform(typeText("crazydog336"));
        onView(withId(R.id.edt_password))
                .perform(typeText("venture"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(android.support.design.R.id.snackbar_text))
                .check(matches(withText("Login failed")));
    }

//    @Test
//    public void changeText_newActivity() {
//        // Type text and then press the button.
//        onView(withId(R.id.inputField)).perform(typeText("NewText"),
//                closeSoftKeyboard());
//        onView(withId(R.id.switchActivity)).perform(click());
//
//        // This view is in a different Activity, no need to tell Espresso.
//        onView(withId(R.id.resultView)).check(matches(withText("NewText")));
//    }
}