package com.torque.patel.basicscience.DataItems


sealed class QuizItem {
data class ListItem(val chapNumber : String,var chapName : String) : QuizItem()
object NativeAdItem : QuizItem()
}