package com.torque.patel.basicscience.DataItems

import com.torque.patel.basicscience.ResultQuestion

sealed class ResultItem {
    data class QuestionResult(val question: ResultQuestion) : ResultItem()
    data class AdResult(val isLoaded: Boolean = false) : ResultItem()
}