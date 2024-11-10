package com.torque.patel.basicscience

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest

class Result : AppCompatActivity() {

    private lateinit var resultAdapter: ResultAdapter
    private val resultItem = mutableListOf<ResultItem>()

    private fun loadResultFromResource(): List<ResultQuestion> {

        // Retrieve the passed data
        val questions = intent.getStringArrayListExtra("QUESTIONS") ?: listOf()
        val optionsR = intent.getStringArrayListExtra("OPTIONS")
            ?.map { it.split("|") } ?: listOf()
        val userAnswers = intent.getIntegerArrayListExtra("USER_ANSWERS") ?: listOf()
        val correctAnswers = intent.getIntegerArrayListExtra("CORRECT_ANSWERS") ?: listOf()
        val totalScore = intent.getIntExtra("TOTAL_SCORE", 0)
        val totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 0)

        //val question = resources.getStringArray(R.array.question)
        //val correctAnswer = resources.getIntArray(R.array.correct_answers)
        val questionList = mutableListOf<ResultQuestion>()

        for (i in questions.indices){
            val optionArrayId = resources.obtainTypedArray(R.array.optionR)
                .getResourceId(i,0)
            val options = resources.getStringArray(optionArrayId)


            questionList.add(
                ResultQuestion(
                    questionText =  questions[i],
                    options = optionsR[i],
                    userAnswerR = userAnswers[i],
                    correctAnswerR = correctAnswers[i]
                )
            )
        }


        return questionList
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = loadResultFromResource()

        result.forEachIndexed { index, question ->

            resultItem.add(ResultItem.QuestionResult(question))

            if ((index + 1) % 2 == 0 && index < result.size - 1) {
                resultItem.add(ResultItem.AdResult())
            }


        }

        val recyclerView = findViewById<RecyclerView>(R.id.resultRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        resultAdapter = ResultAdapter(resultItem)
        recyclerView.adapter = resultAdapter

        loadNativeAd()

        findViewById<Button>(R.id.result_submitButton).setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            checkAnswers()
        }
    }

    private fun loadNativeAd() {
        val adLoader = AdLoader.Builder(    this, "ca-app-pub-3940256099942544/2247696110") // Test ad unit ID
            .forNativeAd { nativeAd ->
                resultAdapter.setNativeAd(nativeAd)
            }
            .build()

        adLoader.loadAd(AdRequest.Builder().build())
    }

    private fun checkAnswers(){
        var score = 0
        resultItem.forEach { item ->
            if (item is ResultItem.QuestionResult) {
                /*if (item.question.selectedAnswer == item.question.correctAnswer) {
                    score++
                }*/

            }

        }

        val totalQuestions = resultItem.count { it is ResultItem.QuestionResult }
        //Toast.makeText(this, "Your score: $score/$totalQuestions", Toast.LENGTH_LONG).show()




    }


}