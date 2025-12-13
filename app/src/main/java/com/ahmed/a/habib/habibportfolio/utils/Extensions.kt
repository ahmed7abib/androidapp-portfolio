package com.ahmed.a.habib.habibportfolio.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import java.net.URLEncoder


fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.openWebPage(url: String) {
    CustomTabsIntent.Builder()
        .setShowTitle(true)
        .build()
        .launchUrl(this, Uri.parse(url))
}

fun Context.openWhatsapp(number: String, message: String = "Hello Dear.") {
    val filteredNumber = number.filter { it.isDigit() }
    openWebPage(
        "https://wa.me/$filteredNumber?text=${
            URLEncoder.encode(message, "UTF-8")
        }"
    )
}

fun Context.openGmail(email: String) {
    startActivity(
        Intent(Intent.ACTION_SENDTO).apply {
            Uri.parse(email).also { data = it }
        }
    )
}