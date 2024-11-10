package com.torque.patel.basicscience

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.android.material.progressindicator.CircularProgressIndicator

class ScoreDashBoard : AppCompatActivity() {
    private var rewardedAd: RewardedAd? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_dashboard_quiz)



        // Load rewarded ad
        loadRewardedAd()

        val questions = intent.getStringArrayListExtra("QUESTIONS") ?: listOf()
        val optionsR = intent.getStringArrayListExtra("OPTIONS")
            ?.map { it.split("|") } ?: listOf()
        val userAnswers = intent.getIntegerArrayListExtra("USER_ANSWERS") ?: listOf()
        val correctAnswers = intent.getIntegerArrayListExtra("CORRECT_ANSWERS") ?: listOf()

        val totalScore = intent.getIntExtra("TOTAL_SCORE", 0)
        val totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 0)
        val totalWrong = intent.getIntExtra("TOTAL_WRONG", 0)
        val totalSkipped = intent.getIntExtra("TOTAL_SKIPPED", 0)

        val scoreNumber = findViewById<TextView>(R.id.score_number)
        val totalWrongNumber = findViewById<TextView>(R.id.total_wrong)
        val totalSkippedNumber = findViewById<TextView>(R.id.total_skip)
        val result_title = findViewById<TextView>(R.id.title_Result)

        scoreNumber.text = totalScore.toString()
        totalWrongNumber.text = totalWrong.toString()
        totalSkippedNumber.text = totalSkipped.toString()

        when {

            totalScore >= 15 -> result_title.text = "Excellent!"
            totalScore >= 10 -> result_title.text = "Good!"
            totalScore <= 10 -> result_title.text = "Not Bad!"
            totalScore <= 5 -> result_title.text = "Poor!"


        }


        val homeButton = findViewById<RelativeLayout>(R.id.result_home)
        val repeatButton = findViewById<RelativeLayout>(R.id.repeat_again)
        val reviewButton = findViewById<RelativeLayout>(R.id.answer_review)

        homeButton.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            finish()
        }

        repeatButton.setOnClickListener {
            Toast.makeText(this, "Repeat Button Clicked", Toast.LENGTH_SHORT).show()
        }

        reviewButton.setOnClickListener {
            showReviewConfirmationDialog(questions, optionsR, userAnswers, correctAnswers)
        }

        val resultProgress = findViewById<CircularProgressIndicator>(R.id.resultProgress)
        resultProgress.max = totalQuestions
        resultProgress.progress = totalScore
    }

    private fun loadRewardedAd() {
        //MobileAds.initialize(this)
        val adRequest = AdRequest.Builder().build()

        RewardedAd.load(this, "ca-app-pub-3940256099942544/5224354917", adRequest, object : RewardedAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                rewardedAd = null
            }

            override fun onAdLoaded(ad: RewardedAd) {
                rewardedAd = ad
            }
        })
    }

    private fun showReviewConfirmationDialog(
        questions: List<String>,
        optionsR: List<List<String>>,
        userAnswers: List<Int>,
        correctAnswers: List<Int>
    ) {
        AlertDialog.Builder(this)
            .setTitle("Watch Ad")
            .setMessage("To review your answers, please watch a short video ad first.")
            .setPositiveButton("Watch Ad") { dialog, _ ->
                dialog.dismiss()
                showRewardedAd(questions, optionsR, userAnswers, correctAnswers)
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

    private fun showRewardedAd(
        questions: List<String>,
        optionsR: List<List<String>>,
        userAnswers: List<Int>,
        correctAnswers: List<Int>
    ) {
        if (rewardedAd == null) {
            Toast.makeText(this, "Ad not ready yet. Please try again later.", Toast.LENGTH_SHORT).show()
            return
        }

        rewardedAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                rewardedAd = null
                loadRewardedAd() // Load the next ad
                navigateToReviewScreen(questions, optionsR, userAnswers, correctAnswers)
            }

            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                // Called when ad fails to show.
                rewardedAd = null
                Toast.makeText(
                    this@ScoreDashBoard,
                    "Failed to show ad. Please try again.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        rewardedAd?.show(this) {
            // Handle the reward
        }
    }

    private fun navigateToReviewScreen(
        questions: List<String>,
        optionsR: List<List<String>>,
        userAnswers: List<Int>,
        correctAnswers: List<Int>
    ) {
        val intent = Intent(this, Result::class.java)
        intent.putStringArrayListExtra("QUESTIONS", ArrayList(questions))
        intent.putStringArrayListExtra("OPTIONS", ArrayList(optionsR.map { it.joinToString("|") }))
        intent.putIntegerArrayListExtra("USER_ANSWERS", ArrayList(userAnswers))
        intent.putIntegerArrayListExtra("CORRECT_ANSWERS", ArrayList(correctAnswers))
        startActivity(intent)
        finish()
    }
}