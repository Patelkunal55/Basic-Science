package com.torque.patel.basicscience

data class Question(val questionText: String,
                    val options: List<String>,
                    val correctAnswer: Int,
                    var selectedAnswer: Int = -1,)
