package com.ahmed.a.habib.habibportfolio.utils

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent


fun Context.openLink(link: String) {
    val uri = Uri.parse(link)
    CustomTabsIntent.Builder().build().launchUrl(this, uri)
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}