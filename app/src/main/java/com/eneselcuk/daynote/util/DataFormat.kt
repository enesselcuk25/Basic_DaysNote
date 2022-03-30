package com.eneselcuk.daynote.util

import java.text.DateFormat

object DataFormat {
    val dataFormat = DateFormat.getDateInstance().format("MMMM d, yyyy ")
}