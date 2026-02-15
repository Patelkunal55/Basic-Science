package com.torque.patel.basicscience.DataItems

sealed class DataItem {
    data class TextItem(val textTitle:String,val text: String) : DataItem()
    data class ImageItem(val imageResId: Int) : DataItem()
    data class WebItem(val url: String) : DataItem()
    object NativeAdItem : DataItem()
}