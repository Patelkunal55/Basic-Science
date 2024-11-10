package com.torque.patel.basicscience

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView

class QuizAdapter(private val items: List<QuizListItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    companion object {
        private const val VIEW_TYPE_QUESTION = 0
        private const val VIEW_TYPE_AD = 1
    }

    private var nativeAd: NativeAd? = null

    class QuestionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val questionText: TextView = view.findViewById(R.id.questionText)
        val radioGroup: RadioGroup = view.findViewById(R.id.optionsRadioGroup)
        val option1: RadioButton = view.findViewById(R.id.option1)
        val option2: RadioButton = view.findViewById(R.id.option2)
        val option3: RadioButton = view.findViewById(R.id.option3)
        val option4: RadioButton = view.findViewById(R.id.option4)
    }

    class AdViewHolder(val adView: NativeAdView) : RecyclerView.ViewHolder(adView)

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is QuizListItem.QuestionItem -> VIEW_TYPE_QUESTION
            is QuizListItem.AdItem -> VIEW_TYPE_AD
            else -> { throw IllegalArgumentException("Invalid item type") }
        }
    }

    override fun getItemCount(): Int = items.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_QUESTION -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.quiz_item, parent, false)
                QuestionViewHolder(view)
            }
            VIEW_TYPE_AD -> {
                val adView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.native_ad_layout, parent, false) as NativeAdView
                AdViewHolder(adView)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }


    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is QuizListItem.QuestionItem -> bindQuestionViewHolder(holder as QuestionViewHolder, item.question)
            is QuizListItem.AdItem -> bindAdViewHolder(holder as AdViewHolder)
            else -> {}
        }
    }

    private fun bindQuestionViewHolder(holder: QuestionViewHolder, question: Question) {
        holder.questionText.text = question.questionText
        holder.option1.text = question.options[0]
        holder.option2.text = question.options[1]
        holder.option3.text = question.options[2]
        holder.option4.text = question.options[3]

        holder.radioGroup.setOnCheckedChangeListener(null)

        when(question.selectedAnswer) {
            0 -> holder.option1.isChecked = true
            1 -> holder.option2.isChecked = true
            2 -> holder.option3.isChecked = true
            3 -> holder.option4.isChecked = true
            else -> holder.radioGroup.clearCheck()
        }

        holder.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            question.selectedAnswer = when(checkedId) {
                holder.option1.id -> 0
                holder.option2.id -> 1
                holder.option3.id -> 2
                holder.option4.id -> 3
                else -> -1
            }
        }
    }


    private fun bindAdViewHolder(holder: AdViewHolder) {
        val adView = holder.adView
        nativeAd?.let { ad ->
            // Headline
            adView.headlineView = adView.findViewById(R.id.ad_headline)
            (adView.headlineView as TextView).text = ad.headline

            // Body
            adView.bodyView = adView.findViewById(R.id.ad_body)
            (adView.bodyView as TextView).text = ad.body

            // Call to action
            adView.callToActionView = adView.findViewById(R.id.ad_call_to_action)
            (adView.callToActionView as Button).text = ad.callToAction

            // Icon
            adView.iconView = adView.findViewById(R.id.ad_icon)
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