package com.torque.patel.basicscience

import android.annotation.SuppressLint
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
import com.google.android.gms.ads.MobileAds
import java.util.ArrayList

class Quiz : AppCompatActivity() {
    private lateinit var quizAdapter: QuizAdapter
    private val quizItems = mutableListOf<QuizListItem>()



    @SuppressLint("Recycle")
    private fun loadQuestionsFromResources(intentTestSet:Int): List<Question> {

        //val intent :Int = intent.getIntExtra("question",0)

        val intent = intent.getIntExtra("question",0)



        val setQuestion1 = arrayOf(R.array.question,R.array.queSet2,R.array.queSet3,
            R.array.queSet4,R.array.queSet4, R.array.queSet5,R.array.queSet6,R.array.queSet7,
            R.array.queSet8,R.array.queSet9,R.array.queSet10,R.array.queSet11, R.array.queSet11,
            R.array.queSet12,R.array.queSet13,R.array.queSet14,R.array.queSet15,R.array.queSet16,
            R.array.queSet16,R.array.queSet17,R.array.queSet18,R.array.queSet19)


        val setQuestion2 = arrayOf(R.array.queSet20,R.array.queSet21,R.array.queSet22,
            R.array.queSet23,R.array.queSet24,R.array.queSet25,R.array.queSet26,R.array.queSet27,
            R.array.queSet28,R.array.queSet29,R.array.queSet30,R.array.queSet31)

        val setQuestion3 = arrayOf(R.array.queSet32,R.array.queSet33,R.array.queSet34,
            R.array.queSet35,R.array.queSet36,R.array.queSet37,R.array.queSet38,R.array.queSet39,
            R.array.queSet40,R.array.queSet41,R.array.queSet42,R.array.queSet43,R.array.queSet44,
            R.array.queSet45,R.array.queSet46,R.array.queSet47,R.array.queSet48,R.array.queSet49,
            R.array.queSet50,R.array.queSet51,R.array.queSet52,R.array.queSet53,R.array.queSet54)

       val setQuestion = when(intentTestSet){
            0 -> {setQuestion1
            //Toast.makeText(this,"Question Set 1",Toast.LENGTH_SHORT).show()
            }
            1 ->{
                //Toast.makeText(this,"Question Set 2",Toast.LENGTH_SHORT).show()
                setQuestion2
            }
           2 -> {
               setQuestion3
           }
            else -> setQuestion1
        }

        val setOption1 = arrayOf(R.array.optionR,R.array.optionSet2,R.array.optionSet3,
            R.array.optionSet4,R.array.optionSet4, R.array.optionSet5,R.array.optionSet6,
            R.array.optionSet7,R.array.optionSet8,R.array.optionSet9,R.array.optionSet10,
            R.array.optionSet11,R.array.optionSet11,R.array.optionSet12,R.array.optionSet13,
            R.array.optionSet14, R.array.optionSet15,R.array.optionSet16,R.array.optionSet16,
            R.array.optionSet17,R.array.optionSet18,R.array.optionSet19)

        val setOption2 = arrayOf(R.array.optionSet20,R.array.optionSet21,R.array.optionSet22,
            R.array.optionSet23,R.array.optionSet24,R.array.optionSet25,R.array.optionSet26,R.array.optionSet27
            ,R.array.optionSet28,R.array.optionSet29,R.array.optionSet30,R.array.optionSet31)

        val setOption3 = arrayOf(R.array.optionSet32, R.array.optionSet33, R.array.optionSet34,
            R.array.optionSet35,R.array.optionSet36,R.array.optionSet37,R.array.optionSet38,
            R.array.optionSet39,R.array.optionSet40,R.array.optionSet41,R.array.optionSet42,R.array.optionSet43,
            R.array.optionSet44,R.array.optionSet45,R.array.optionSet46,R.array.optionSet47,R.array.optionSet48,
            R.array.optionSet49,R.array.optionSet50,R.array.optionSet51,R.array.optionSet52,R.array.optionSet53,R.array.optionSet54)
        val setOption = when(intentTestSet){
            0 -> { setOption1
                //Toast.makeText(this,"Option Set 1",Toast.LENGTH_SHORT).show()
            }
            1 -> {
                setOption2
            }
            2 -> {
                setOption3
            }

            else -> {setOption1}

        }


        val setAnswer1 = arrayOf(R.array.answers,R.array.answers2,R.array.answers3,R.array.answers4,R.array.answers4,
            R.array.answers5,R.array.answers6,R.array.answers7,R.array.answers8,R.array.answers9,R.array.answers10,R.array.answers11,
            R.array.answers11,R.array.answers12,R.array.answers13,R.array.answers14,R.array.answers15,R.array.answers16,R.array.answers16,
            R.array.answers17,R.array.answers18,R.array.answers19)

        val setAnswer2 = arrayOf(R.array.answers20,R.array.answers21,R.array.answers22,
            R.array.answers23,R.array.answers24,R.array.answers25,R.array.answers26,R.array.answers27,
            R.array.answers28,R.array.answers29,R.array.answers30,R.array.answers31)

        val setAnswer3 = arrayOf(R.array.answers32,R.array.answers33,R.array.answers34,
            R.array.answers35,R.array.answers36,R.array.answers37,R.array.answers38,R.array.answers39,
            R.array.answers40,R.array.answers41,R.array.answers42,R.array.answers43,R.array.answers44,
            R.array.answers45,R.array.answers46,R.array.answers47,R.array.answers48,R.array.answers49,
            R.array.answers50,R.array.answers51,R.array.answers52,R.array.answers53,R.array.answers54)




        val setAnswer = when(intentTestSet){
            0 -> {setAnswer1
                //Toast.makeText(this,"Answer Set 1",Toast.LENGTH_SHORT).show()
            }
            1 -> {
                setAnswer2
            }

            2 -> {
                setAnswer3
            }

            else -> {setAnswer1}
        }
        val getQuestion = setQuestion[intent]
        val getOption = setOption[intent]
        val getAnswer = setAnswer[intent]

        //Toast.makeText(this,intent.toString(),Toast.LENGTH_SHORT).show()



        val questions = resources.getStringArray(getQuestion)
        val correctAnswers = resources.getIntArray(getAnswer)
        val questionList = mutableListOf<Question>()

        for (i in questions.indices) {
            val optionsArrayId = resources.obtainTypedArray(getOption)
                .getResourceId(i, 0)
            val options = resources.getStringArray(optionsArrayId)

            questionList.add(
                Question(
                    questionText = questions[i],
                    options = options.toList(),
                    correctAnswer = correctAnswers[i]
                )
            )

        }

        return questionList
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        // Initialize the Mobile Ads SDK
        MobileAds.initialize(this)



         // Load questions from resources

        val intentTestSet = intent.getIntExtra("testSet",0)
        val questions = loadQuestionsFromResources(intentTestSet)

        questions.forEachIndexed { index, question ->
            quizItems.add(QuizListItem.QuestionItem(question))
            // Add an ad item after every 5 questions
            if ((index + 1) % 5 == 0 && index < questions.size - 1) {
                quizItems.add(QuizListItem.AdItem())
            }
        }







        // Convert questions to QuizListItems and add ad placeholders


        val recyclerView = findViewById<RecyclerView>(R.id.quizRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        quizAdapter = QuizAdapter(quizItems)
        recyclerView.adapter = quizAdapter

        loadNativeAd()

        findViewById<Button>(R.id.submitButton).setOnClickListener {
            checkAnswers()
        }



    }

    private fun loadNativeAd() {
        val adLoader = AdLoader.Builder(    this, "ca-app-pub-3940256099942544/2247696110") // Test ad unit ID
            .forNativeAd { nativeAd ->
                quizAdapter.setNativeAd(nativeAd)
            }
            .build()

        adLoader.loadAd(AdRequest.Builder().build())
    }

    @SuppressLint("SuspiciousIndentation")
    private fun checkAnswers() {
        var score = 0
        var wrong = 0
        var skipped = 0
        /*quizItems.forEach { item ->
            if (item is QuizListItem.QuestionItem) {
                if (item.question.selectedAnswer == item.question.correctAnswer) {
                    score++
                }
            }
        }*/


        //var score = 0
        val userAnswers = mutableListOf<Int>() // To store user-selected answers
        val correctAnswers = mutableListOf<Int>() // To store correct answers
        val questionsList = mutableListOf<String>() // To store questions
        val optionsList = mutableListOf<List<String>>() // To store options

        quizItems.forEach { item ->
            if (item is QuizListItem.QuestionItem) {
                val question = item.question
                questionsList.add(question.questionText)
                optionsList.add(question.options)
                correctAnswers.add(question.correctAnswer)
                userAnswers.add(question.selectedAnswer)
                /*if (question.selectedAnswer == question.correctAnswer) {
                    score++
                }else {



                }*/

                when {
                    question.selectedAnswer == -1 -> skipped++ // No answer selected
                    question.selectedAnswer == question.correctAnswer -> score++
                    else -> wrong++
                }
            }




        }




        val totalQuestions = quizItems.count { it is QuizListItem.QuestionItem }

        Toast.makeText(
            this,
            "Score: $score/$totalQuestions | Wrong: $wrong | Skipped: $skipped",
            Toast.LENGTH_LONG
        ).show()

        //val totalQuestions = quizItems.count { it is QuizListItem.QuestionItem }
        //Toast.makeText(this, "Your score: $score/$totalQuestions Wrong: $wrong", Toast.LENGTH_LONG).show()

        // Move to Next Activity i.e ScoreDashBoard
        val intent = Intent(this, ScoreDashBoard::class.java)
            intent.apply {
            // Pass data using putExtra
            putStringArrayListExtra("QUESTIONS", ArrayList(questionsList))
            putStringArrayListExtra("OPTIONS", ArrayList(optionsList.map { it.joinToString("|") }))
            putIntegerArrayListExtra("USER_ANSWERS", ArrayList(userAnswers))
            putIntegerArrayListExtra("CORRECT_ANSWERS", ArrayList(correctAnswers))
            putExtra("TOTAL_SCORE", score)
            putExtra("TOTAL_QUESTIONS", totalQuestions)
            putExtra("TOTAL_WRONG", wrong)
            putExtra("TOTAL_SKIPPED", skipped)
        }

        // Start the ResultActivity
        startActivity(intent)
        finish() // Optional: closes the current activity


    }


}