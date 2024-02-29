package com.example.mbti_prac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2

class MbtiSurveyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mbti_survey)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager_survey)
        viewPager.adapter = SurveyViewPagerAdapter(this)
        viewPager.isUserInputEnabled = true;

        val btn_survey = findViewById<Button>(R.id.btn_survey_submit)
        val tv_survet_title = findViewById<TextView>(R.id.tv_survey_title)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when(position) {
                    0 -> tv_survet_title.text = getString(R.string.question1_title)
                    1 -> tv_survet_title.text = getString(R.string.question2_title)
                    2 -> tv_survet_title.text = getString(R.string.question3_title)
                    3 -> tv_survet_title.text = getString(R.string.question4_title)
                }
            }
        })
    }
}