package com.example.mbti_prac

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class SurveyViewPagerFrag: Fragment() {
    private var pageType = 0
    private lateinit var questionListPage1 : List<MbtiQuestion>
    private lateinit var questionListPage2 : List<MbtiQuestion>
    private lateinit var questionListPage3 : List<MbtiQuestion>
    private lateinit var questionListPage4 : List<MbtiQuestion>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{ pageType = it.getInt(MBTI_SURVEY_PAGE_TYPE) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frag_survey, container, false)

        questionListPage1 = listOf(
            MbtiQuestion(getString(R.string.question1_1), getString(R.string.question1_2_answer1), getString(R.string.question1_2_answer2)),
            MbtiQuestion(getString(R.string.question1_2), getString(R.string.question1_2_answer1), getString(R.string.question1_2_answer2)),
            MbtiQuestion(getString(R.string.question1_3), getString(R.string.question1_2_answer1), getString(R.string.question1_2_answer2))
        )
        questionListPage2 = listOf(
            MbtiQuestion(getString(R.string.question2_1), getString(R.string.question2_2_answer1), getString(R.string.question2_2_answer2)),
            MbtiQuestion(getString(R.string.question2_2), getString(R.string.question2_2_answer1), getString(R.string.question2_2_answer2)),
            MbtiQuestion(getString(R.string.question2_3), getString(R.string.question2_2_answer1), getString(R.string.question2_2_answer2))
        )
        questionListPage3 = listOf(
            MbtiQuestion(getString(R.string.question3_1), getString(R.string.question3_2_answer1), getString(R.string.question3_2_answer2)),
            MbtiQuestion(getString(R.string.question3_2), getString(R.string.question3_2_answer1), getString(R.string.question3_2_answer2)),
            MbtiQuestion(getString(R.string.question3_3), getString(R.string.question3_2_answer1), getString(R.string.question3_2_answer2))
        )
        questionListPage4 = listOf(
            MbtiQuestion(getString(R.string.question4_1), getString(R.string.question4_2_answer1), getString(R.string.question4_2_answer2)),
            MbtiQuestion(getString(R.string.question4_2), getString(R.string.question4_2_answer1), getString(R.string.question4_2_answer2)),
            MbtiQuestion(getString(R.string.question4_3), getString(R.string.question4_2_answer1), getString(R.string.question4_2_answer2))
        )
        var surveyData = setSurveyQuestions(pageType)

        val adapter = SurveyRecyclerViewAdapter(surveyData)
        val recyclerView: RecyclerView? = view.findViewById(R.id.rv_survey)
        recyclerView?.layoutManager = LinearLayoutManager(view.context)
        recyclerView?.adapter = adapter

        val viewPager : ViewPager2? = activity?.findViewById<ViewPager2>(R.id.viewPager_survey)
        val btn_survey_submit = view.findViewById<Button>(R.id.btn_survey_submit)
        btn_survey_submit.setOnClickListener{
            viewPager?.currentItem = pageType + 1
        }

        if(pageType == 3) {
            btn_survey_submit.text = "submit"
            adapter.notifyDataSetChanged()
        } else {
            btn_survey_submit.text = "next page"
            adapter.notifyDataSetChanged()
        }
        return view
    }

    fun setSurveyQuestions(page: Int): List<MbtiQuestion>{
        when(page){
            0 -> return questionListPage1
            1 -> return questionListPage2
            2 -> return questionListPage3
            else -> return questionListPage4
        }
    }
    companion object{
        const val MBTI_SURVEY_PAGE_TYPE = "pageType"
        fun newInstnace(pageType: Int): Fragment{
            val frag = SurveyViewPagerFrag()
            val args = Bundle()

            args.putInt(MBTI_SURVEY_PAGE_TYPE, pageType)
            frag.arguments = args
            return frag
        }
    }
}