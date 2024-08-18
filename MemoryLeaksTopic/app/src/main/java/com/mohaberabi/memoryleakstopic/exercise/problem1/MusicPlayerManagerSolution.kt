package com.mohaberabi.memoryleakstopic.exercise.problem1

import android.app.Activity
import java.lang.ref.WeakReference


object MusicPlayerManagerSolution {
    private var currentActivity: WeakReference<Activity>? = null
    private var currentTrack: WeakReference<Track>? = null

    fun registerActivity(activity: Activity) {
        currentActivity = WeakReference(activity)
    }

    fun play(track: Track) {
        currentTrack = WeakReference(track)
        // Other playback logic
    }

    fun updateUI() {
        currentActivity?.get()?.let { activity ->
            // Update UI with current track details
        }
    }
}
