package com.mohaberabi.memoryleakstopic.exercise.problem1

import android.app.Activity

data class Track(val name: String)
object MusciPlayerManagerPRoblem {
    private var currentActivity: Activity? = null
    private var currentTrack: Track? = null

    fun registerActivity(activity: Activity) {
        currentActivity = activity
    }

    fun play(track: Track) {
        currentTrack = track
        // Other playback logic
    }

    fun updateUI() {
        currentActivity?.let {
            // Update UI with current track details
        }
    }
}
