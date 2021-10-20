package com.sachin.lib.notification

import android.service.notification.StatusBarNotification
import androidx.core.app.NotificationCompat
import java.util.*

fun StatusBarNotification.getTitle(): String? = notification.getTitle()

fun StatusBarNotification.getMessage(): String? = notification.getMessage()

fun StatusBarNotification.getExtended(): String? = notification.getExtended()

fun StatusBarNotification.getActions(): ArrayList<NotificationCompat.Action> =
    notification.getActions()

fun StatusBarNotification.getQuickReplyAction(packageName: String) =
    notification.getQuickReplyAction(packageName)