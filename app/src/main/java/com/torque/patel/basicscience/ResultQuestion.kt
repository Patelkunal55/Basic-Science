package com.torque.patel.basicscience

data class ResultQuestion(val questionText: String,
                          val options: List<String>,
                          val userAnswerR: Int,
                          val correctAnswerR: Int)
