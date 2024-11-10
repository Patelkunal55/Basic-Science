package com.torque.patel.basicscience

sealed class QuizListItem {
    data class QuestionItem(val question: Question) : QuizListItem()
    data class AdItem(val isLoaded: Boolean = false) : QuizListItem()

}