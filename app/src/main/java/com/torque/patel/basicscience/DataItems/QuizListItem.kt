package com.torque.patel.basicscience.DataItems

import com.torque.patel.basicscience.Question

sealed class QuizListItem {
    data class QuestionItem(val question: Question) : QuizListItem()
    data class AdItem(val isLoaded: Boolean = false) : QuizListItem()

}