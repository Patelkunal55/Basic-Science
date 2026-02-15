package com.torque.patel.basicscience

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.torque.patel.basicscience.adapter.QuizAdapter
import com.torque.patel.basicscience.DataItems.QuizListItem
import java.util.ArrayList

class Quiz : AppCompatActivity() {
    private lateinit var quizAdapter: QuizAdapter
    private val quizItems = mutableListOf<QuizListItem>()

    lateinit var mainViewModel: MainViewModel

    private var mInterstitialAd: InterstitialAd? = null
    private final var TAG = "MainActivity"






    //private var intertialAds : String = R.string.quiz_interital_ads


    @SuppressLint("Recycle")
    private fun loadQuestionsFromResources(intentTestSet: Int): List<Question> {

        //val intent :Int = intent.getIntExtra("question",0)

        val intent = intent.getIntExtra("question", 0)


        mainViewModel = ViewModelProvider(this).get(MainViewModel::class)

        val setQuestion = when (intentTestSet) {
            0 -> {
                mainViewModel.setQuestion1
                //Toast.makeText(this,"Question Set 1",Toast.LENGTH_SHORT).show()
            }

            1 -> {
                //Toast.makeText(this,"Question Set 2",Toast.LENGTH_SHORT).show()
                mainViewModel.setQuestion2
            }

            2 -> {
                mainViewModel.setQuestion3
            }

            else -> mainViewModel.setQuestion1
        }

        val setOption = when (intentTestSet) {
            0 -> {
                mainViewModel.setOption1
                //Toast.makeText(this,"Option Set 1",Toast.LENGTH_SHORT).show()
            }

            1 -> {
                mainViewModel.setOption2
            }

            2 -> {
                mainViewModel.setOption3
            }

            else -> {
                mainViewModel.setOption1
            }

        }

        val setAnswer = when (intentTestSet) {
            0 -> {
                mainViewModel.setAnswer1
                //Toast.makeText(this,"Answer Set 1",Toast.LENGTH_SHORT).show()
            }

            1 -> {
                mainViewModel.setAnswer2
            }

            2 -> {
                mainViewModel.setAnswer3
            }

            else -> {
                mainViewModel.setAnswer1
            }
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



        val number:Int = intent.getIntExtra("number",0)


        // Initialize the Mobile Ads SDK
        MobileAds.initialize(this)








        // Load questions from resources

        val intentTestSet = intent.getIntExtra("testSet", 0)

        //Toast.makeText(this,"Position: ${intentTestSet}",Toast.LENGTH_SHORT).show()
        val questions = loadQuestionsFromResources(intentTestSet)

        questions.forEachIndexed { index, question ->
            quizItems.add(QuizListItem.QuestionItem(question))
            // Add an ad item after every 5 questions
            if ((index + 1) % 5 == 0 && index < questions.size - 1) {
                quizItems.add(QuizListItem.AdItem())
            }
        }

        toolBar(intentTestSet)

        val backBtn = findViewById<ImageView>(R.id.btnBack)
        backBtn.setOnClickListener {

            onBackPressedBtn(intentTestSet)

        }

        // Convert questions to QuizListItems and add ad placeholders


        val recyclerView = findViewById<RecyclerView>(R.id.quizRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        quizAdapter = QuizAdapter(quizItems, intentTestSet)
        recyclerView.adapter = quizAdapter

        loadNativeAd()

        loadInterstitialAd()


        findViewById<Button>(R.id.submitButton).setOnClickListener {
            checkAnswers()


        }

        val callback = object : OnBackPressedCallback(true) { // 'true' means the callback is enabled initially
            override fun handleOnBackPressed() {
                // Your custom logic to handle the back event
                // If you want the system's default behavior, disable this callback
                // and call onBackPressedDispatcher.onBackPressed()

                when(intentTestSet){

                    in 0..2 -> {
                        val intent = Intent(application, QuizMenu::class.java)
                        intent.putExtra("number", intentTestSet)
                        startActivity(intent)
                    }

                }
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)


    }



    private fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            getString(R.string.menu_quiz_interital_ads), // Replace with your ad unit ID
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(TAG, adError.toString())
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d(TAG, "Ad was loaded.")
                    mInterstitialAd = interstitialAd
                    setFullScreenContentCallback()
                }
            }
        )
    }

    private fun setFullScreenContentCallback() {
        mInterstitialAd?.fullScreenContentCallback = object :
            FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                Log.d(TAG, "Ad was dismissed.")
                // Called when ad is dismissed.
                // Set the ad reference to null so you don't show the ad a second time.
                mInterstitialAd = null
                // Load the next ad
                loadInterstitialAd()
            }

            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                Log.e(TAG, "Ad failed to show.")
                // Called when ad fails to show.
                mInterstitialAd = null
            }

            override fun onAdShowedFullScreenContent() {
                Log.d(TAG, "Ad showed fullscreen content.")
                // Called when ad is shown.
            }
        }
    }

    private fun showInterstitialAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        } else {
            Log.d(TAG, "The interstitial ad wasn't ready yet.")
        }
    }

    override fun onStop() {
        super.onStop()
        showInterstitialAd()
    }



    private fun toolBar(num: Int) {



        //toolbar.setTitleTextColor(resources.getColor(R.color.colorWhite)) // set Title text color


        when(num){
            0 -> configureToolbar("Physics Quiz",R.drawable.ic_quiz_icon,R.color.colorPrimary)
            1 -> configureToolbar("Chemistry Quiz",R.drawable.ic_quiz_icon,R.color.colorYello)
            2 -> configureToolbar("Biology Quiz",R.drawable.ic_quiz_icon,R.color.colorGreenLight)
        }


        //setSupportActionBar(toolbar)

        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //supportActionBar?.setDisplayShowHomeEnabled(true)

        // Set the back button color to white
        //supportActionBar?.setHomeAsUpIndicator(R.drawable.arrow_back_2)
        //val upArrow = ContextCompat.getDrawable(this, R.drawable.arrow_back_2)
        //upArrow?.setColorFilter(
           // ContextCompat.getColor(this, R.color.colorWhite),
            //PorterDuff.Mode.SRC_ATOP
        //)
        //supportActionBar?.setHomeAsUpIndicator(upArrow)
    }

    fun configureToolbar(title: String,logoRes:Int,colorRes:Int){

        val logo_img = findViewById<ImageView>(R.id.toolbar_logo_img)
        val tool_text = findViewById<TextView>(R.id.toolbar_text)

        val toolbar = findViewById<Toolbar>(R.id.quiz_toolbar)
        tool_text.text = title
        logo_img.setImageResource(logoRes)
        toolbar.backgroundTintList = ContextCompat.getColorStateList(this, colorRes)
        window.statusBarColor = ContextCompat.getColor(this, colorRes)

    }

    private fun onBackPressedBtn(num:Int) {


        when(num){

            in 0..2 -> {
                val intent = Intent(this, QuizMenu::class.java)
                intent.putExtra("number", num)
                startActivity(intent)
            }

        }



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                true

            }

            else -> super.onOptionsItemSelected(item)

        }
    }

    private fun loadNativeAd() {
        val adLoader =
            AdLoader.Builder(this, getString(R.string.quiz_adunit_id)) // Test ad unit ID
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

        /*Toast.makeText(
            this,
            "Score: $score/$totalQuestions | Wrong: $wrong | Skipped: $skipped",
            Toast.LENGTH_LONG
        ).show()*/

        //val totalQuestions = quizItems.count { it is QuizListItem.QuestionItem }
        //Toast.makeText(this, "Your score: $score/$totalQuestions Wrong: $wrong", Toast.LENGTH_LONG).show()
        val intentTestSet = intent.getIntExtra("testSet", 0)
        val que_intent = intent.getIntExtra("question", 0)
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

            putExtra("testSet", intentTestSet)
            putExtra("question", que_intent)

            //Toast.makeText(this@Quiz, "Position: ${que_intent} ", Toast.LENGTH_LONG).show()

        }

        // Start the ResultActivity
        startActivity(intent)
        finish() // Optional: closes the current activity


    }


}