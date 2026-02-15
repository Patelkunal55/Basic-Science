package com.torque.patel.basicscience.DataItems

sealed class DataChapter {
    data class ChapterItem(val chapterNumber: String, val chapterName: String) : DataChapter()
    object NativeItems : DataChapter()
}
