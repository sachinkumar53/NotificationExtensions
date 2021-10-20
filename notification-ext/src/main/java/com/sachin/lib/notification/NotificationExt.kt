package com.sachin.lib.notification

import android.app.Notification
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import java.util.*

private const val TAG = "NotificationContentExt"

fun Notification.getTitle(): String? {
    Log.d(TAG, "Getting title from extras..")
    val msg = extras.getString("android.title")
    Log.d("Title Big", "" + extras.getString("android.title.big"))
    return msg
}

fun Notification.getMessage(): String? {
    Log.d(TAG, "Getting message from extras..")
    Log.d("Text", "" + extras.getCharSequence("android.text"))
    Log.d("Big Text", "" + extras.getCharSequence("android.bigText"))
    Log.d("Title Big", "" + extras.getCharSequence("android.title.big"))
    Log.d("Info text", "" + extras.getCharSequence("android.infoText"))
    Log.d("Info text", "" + extras.getCharSequence("android.infoText"))
    Log.d("Subtext", "" + extras.getCharSequence("android.subText"))
    Log.d("Summary", "" + extras.getString("android.summaryText"))
    val chars = extras.getCharSequence("android.text")
    val chars1 = extras.getString("android.summaryText")
    return when {
        !chars.isNullOrEmpty() -> chars.toString()
        !chars1.isNullOrEmpty() -> chars1.toString()
        else -> null
    }
}

fun Notification.getExtended(): String? {
    Log.d(TAG, "Getting message from extras..")
    val lines = extras.getCharSequenceArray("android.textLines")
    val sb = StringBuilder()

    return if (!lines.isNullOrEmpty()) {
        lines.forEach {
            if (!it.isNullOrEmpty()) {
                sb.append(it)
                sb.append('\n')
            }
        }
        return sb.toString().trim { it <= ' ' }
    } else {
        val chars = extras.getCharSequence("android.bigText")
        if (!chars.isNullOrEmpty()) chars.toString() else getMessage()
    }
}

fun Notification.getActions(): ArrayList<NotificationCompat.Action> {
    val actions = arrayListOf<NotificationCompat.Action>()
    val wearableExtender = NotificationCompat.WearableExtender(this)
    if (wearableExtender.actions.size > 0) {
        for (action in wearableExtender.actions)
            actions.add(action)
    }
    return actions
}

fun Notification.getQuickReplyAction(packageName: String) {
    for (i in 0..NotificationCompat.getActionCount(this)) {
        val action = NotificationCompat.getAction(this, i)
        if (action?.remoteInputs != null) {

        }
    }
}