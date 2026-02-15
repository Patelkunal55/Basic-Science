package com.torque.patel.basicscience

import com.google.android.gms.ads.AdView
import com.torque.patel.basicscience.DataItems.QuizItem

sealed class DataInline {

    data class MenuItem(
        val chapterNum: String,
        val chapterName: String,

    ):DataInline()

    data class HeaderItem(
        val title: String,
        val subtitle: String
    ):DataInline()

    data class Ad(val adView: AdView) : DataInline()
    //data class InlineAdItem(val adView: AdView) : DataInline()
}