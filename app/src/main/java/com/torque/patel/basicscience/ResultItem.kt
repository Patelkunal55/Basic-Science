package com.torque.patel.basicscience

sealed class ResultItem {
    data class QuestionResult(val question: ResultQuestion) : ResultItem()
    data class AdResult(val isLoaded: Boolean = false) : ResultItem()
}