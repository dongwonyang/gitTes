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

    private var questionList = listOf(
        MbtiQuestion(R.string.question1_1.toString(), R.string.question1_1_answer1.toString(), R.string.question1_1_answer2.toString())
    )
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

        var surveyData = ArrayList<MbtiQuestion>()
        surveyData.add(MbtiQuestion("1.","dd", "ss"))
        surveyData.add(MbtiQuestion("1.","dd", "ss"))
        surveyData.add(MbtiQuestion("1.","dd", "ss"))

        val adapter = SurveyRecyclerViewAdapter(surveyData)
        val recyclerView: RecyclerView? = view.findViewById(R.id.rv_survey)
        recyclerView?.layoutManager = LinearLayoutManager(view.context)
        recyclerView?.adapter = adapter

        val viewPager : ViewPager2? = activity?.findViewById<ViewPager2>(R.id.viewPager_survey)
        val btn_survey_submit = view.findViewById<Button>(R.id.btn_survey_submit)
        btn_survey_submit.setOnClickListener{
            viewPager?.currentItem = pageType + 1
        }



        return view
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