package com.torque.patel.basicscience.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView
import com.torque.patel.basicscience.Question
import com.torque.patel.basicscience.DataItems.QuizListItem
import com.torque.patel.basicscience.R

class QuizAdapter(private val items: List<QuizListItem>,val number:Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    companion object {
        private const val VIEW_TYPE_QUESTION = 0
        private const val VIEW_TYPE_AD = 1
    }

    private var nativeAd: NativeAd? = null

    class QuestionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val card_border: LinearLayout = view.findViewById(R.id.card_view)
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


        when(number){
            0 -> {
                holder.card_border.setBackgroundResource(R.drawable.card_border_two)
                holder.option1.setButtonTintList(holder.option1.context.getColorStateList(R.color.colorBlue))
                holder.option2.setButtonTintList(holder.option2.context.getColorStateList(R.color.colorBlue))
                holder.option3.setButtonTintList(holder.option3.context.getColorStateList(R.color.colorBlue))
                holder.option4.setButtonTintList(holder.option4.context.getColorStateList(R.color.colorBlue))
            }

            1 -> {
                holder.card_border.setBackgroundResource(R.drawable.card_border_three)
                holder.option1.setButtonTintList(holder.option1.context.getColorStateList(R.color.orange))
                holder.option2.setButtonTintList(holder.option2.context.getColorStateList(R.color.orange))
                holder.option3.setButtonTintList(holder.option3.context.getColorStateList(R.color.orange))
                holder.option4.setButtonTintList(holder.option4.context.getColorStateList(R.color.orange))
            }

            2 -> {
                holder.card_border.setBackgroundResource(R.drawable.card_border)
                holder.option1.setButtonTintList(holder.option1.context.getColorStateList(R.color.colorGreenLight))
                holder.option2.setButtonTintList(holder.option2.context.getColorStateList(R.color.colorGreenLight))
                holder.option3.setButtonTintList(holder.option3.context.getColorStateList(R.color.colorGreenLight))
                holder.option4.setButtonTintList(holder.option4.context.getColorStateList(R.color.colorGreenLight))
            }


        }




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

            // LinearLayout
            adView.findViewById<LinearLayout>(R.id.quizAd_linearLayout).visibility = View.VISIBLE

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

            // Show views after binding data
            adView.headlineView?.visibility = View.VISIBLE
            adView.bodyView?.visibility = View.VISIBLE
            adView.callToActionView?.visibility = View.VISIBLE
            adView.mediaView?.visibility = View.VISIBLE


            adView.setNativeAd(ad)
        }
    }

    fun setNativeAd(ad: NativeAd) {
        this.nativeAd = ad
        notifyDataSetChanged()
    }


}