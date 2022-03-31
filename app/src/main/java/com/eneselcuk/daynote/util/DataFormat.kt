package com.eneselcuk.daynote.util

import java.util.*

object DataFormat {
    private val date = Calendar.getInstance()
    var dayToday = android.text.format.DateFormat.format("EE dd, yyyy", date).toString()
}