package com.example.noteit


import android.content.ContentValues.TAG
import android.util.Log
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Rule



/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    var activityScenarioRule=ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun addNote() {
        // Context of the app under test.
        Log.d(TAG,"app launched")
        Thread.sleep(5000)
        onView(withId(R.id.fragment_home_fab_btn)).perform(click())
        Log.d(TAG,"clicked on add note")
        Espresso.pressBack();
        Log.d(TAG,"went back on home screen")
        Thread.sleep(5000)
        onView(withId(R.id.fragment_home_fab_btn)).perform(click())
        Log.d(TAG,"clicked on add note")
        Thread.sleep(5000)
        onView(withId(R.id.fragment_editor_text_title)).perform(typeText(textTitle))
        onView(withId(R.id.fragment_editor_text_description)).perform(typeText(noteText))
        Thread.sleep(5000)
        onView(withId(R.id.fragment_editor_btn_save)).perform(click())
        onView(withId(R.id.fragment_custom_dialog_btn_positive)).perform(click())
        Log.d(TAG,"note saved")
        Thread.sleep(5000)
        onView(withId(R.id.single_note)).perform(longClick())
        Log.d(TAG,"long click on note")
        onView(withId(R.id.single_note_iv_delete)).perform(click())
        Log.d(TAG,"note deleted")
        onView(withId(R.id.fragment_home_text_create_note)).check(matches(withText(homeScreenText)) )
        Log.d(TAG,"text verified on home screen")


    }

       //static members
    companion object{
        const val homeScreenText : String ="Create your first note !"
        const val noteText:String= "First Basic Script"
        const val textTitle:String="First note"
    }


}