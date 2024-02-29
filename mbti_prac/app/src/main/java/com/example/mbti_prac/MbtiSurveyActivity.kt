package com.example.mbti_prac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MbtiSurveyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mbti_survey)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager_survey)
        viewPager.adapter = SurveyViewPagerAdapter(this)
        viewPager.isUserInputEnabled = true;
    }
}