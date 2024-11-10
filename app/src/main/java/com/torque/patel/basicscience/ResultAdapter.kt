package com.torque.patel.basicscience

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView

class ResultAdapter(private val results: List<ResultItem>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_QUESTION_RESULT = 0
        private const val VIEW_TYPE_AD_RESULT = 1
    }


    private var nativeAd: NativeAd? = null

    class ResultViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val questionText: TextView = view.findViewById(R.id.result_question)
        val option1: TextView = view.findViewById(R.id.option1)
        val option2: TextView = view.findViewById(R.id.option2)
        val option3: TextView = view.findViewById(R.id.option3)
        val option4: TextView = view.findViewById(R.id.option4)
        val yourAnswer: TextView = view.findViewById(R.id.your_answer)
        val correctAnswer: TextView = view.findViewById(R.id.correct_answer)

    }

    class AdViewHolder(val adView: NativeAdView) : RecyclerView.ViewHolder(adView)


    override fun getItemViewType(position: Int): Int {
        return when (results[position]) {
            is ResultItem.QuestionResult -> VIEW_TYPE_QUESTION_RESULT
            is ResultItem.AdResult -> VIEW_TYPE_AD_RESULT
            else -> throw IllegalArgumentException("Invalid result item type")


        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_QUESTION_RESULT -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_result, parent, false)
                ResultViewHolder(view)
            }

            VIEW_TYPE_AD_RESULT -> {
                val adView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.result_ad_layout, parent, false) as NativeAdView
                AdViewHolder(adView)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int = results.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = results[position]) {
            is ResultItem.QuestionResult -> bindQuestionResultViewHolder(holder as ResultViewHolder, item)
            is ResultItem.AdResult -> bindAdResultViewHolder(holder as AdViewHolder)
            else -> {}

        }
    }

    @SuppressLint("SetTextI18n")
    private fun bindQuestionResultViewHolder(holder: ResultViewHolder, item: ResultItem.QuestionResult) {
        val question = item.question
        holder.questionText.text = question.questionText
        holder.option1.text = question.options[0]
        holder.option2.text = question.options[1]
        holder.option3.text = question.options[2]
        holder.option4.text = question.options[3]

        //holder.yourAnswer.text = question.selectedAnswer.toString()
        //holder.correctAnswer.text = question.correctAnswer.toString()

        if (item.question.userAnswerR != -1) {

            holder.yourAnswer.text =
                "Your Answer: ${item.question.options[item.question.userAnswerR]}"
            holder.yourAnswer.setTextColor(
                if (item.question.userAnswerR == item.question.correctAnswerR)
                    Color.GREEN
                else
                    Color.RED


            )

            //holder.correctAnswer.text = "Correct Answer: ${item.question.options[item.question.correctAnswerR]}"
            holder.correctAnswer.text = question.options[item.question.correctAnswerR]

        } else {
            holder.yourAnswer.text = "No Selected Answer"
            holder.yourAnswer.setTextColor(Color.GRAY)
        }




        holder.correctAnswer.text = "Correct Answer:  ${item.question.options[item.question.correctAnswerR]}"



    }


    private fun bindAdResultViewHolder(holder: AdViewHolder) {
        val adView = holder.adView
        nativeAd?.let { ad ->
            // Headline
            adView.headlineView = adView.findViewById(R.id.result_ad_headline)
            (adView.headlineView as TextView).text = ad.headline

            // Body
            adView.bodyView = adView.findViewById(R.id.result_ad_body)
            (adView.bodyView as TextView).text = ad.body

            // Call to action
            adView.callToActionView = adView.findViewById(R.id.result_ad_call_to_action)
            (adView.callToActionView as Button).text = ad.callToAction

            // Icon
            adView.iconView = adView.findViewById(R.id.result_ad_icon)
            if (ad.icon != null) {
                (adView.iconView as ImageView).setImageDrawable(ad.icon?.drawable)
                adView.iconView?.visibility = View.VISIBLE
            } else {
                adView.iconView?.visibility = View.GONE
            }

            adView.setNativeAd(ad)
        }
    }

    fun setNativeAd(ad: NativeAd) {
        this.nativeAd = ad
        notifyDataSetChanged()
    }
}