package com.example.readcode

import android.content.Context

private const val PREFS_NAME = "readcode_progress"
private const val KEY_COMPLETED = "completed_ids"
private const val KEY_ATTEMPTED = "attempted_ids"

/**
 * Reads and writes problem completion state to SharedPreferences.
 * Completed IDs are stored as a Set<String>; attempted-but-failed IDs in a separate set.
 */
object ProgressRepository {

    fun load(context: Context): Map<String, Boolean> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val completed = prefs.getStringSet(KEY_COMPLETED, emptySet()) ?: emptySet()
        val attempted = prefs.getStringSet(KEY_ATTEMPTED, emptySet()) ?: emptySet()
        val result = mutableMapOf<String, Boolean>()
        for (id in completed) result[id] = true
        for (id in attempted) if (id !in result) result[id] = false
        return result
    }

    fun save(context: Context, id: String, correct: Boolean) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        if (correct) {
            val completed = (prefs.getStringSet(KEY_COMPLETED, emptySet()) ?: emptySet()).toMutableSet()
            completed.add(id)
            editor.putStringSet(KEY_COMPLETED, completed)
            // Remove from attempted if it was there
            val attempted = (prefs.getStringSet(KEY_ATTEMPTED, emptySet()) ?: emptySet()).toMutableSet()
            attempted.remove(id)
            editor.putStringSet(KEY_ATTEMPTED, attempted)
        } else {
            // Only record as attempted-failed if not already completed
            val completed = prefs.getStringSet(KEY_COMPLETED, emptySet()) ?: emptySet()
            if (id !in completed) {
                val attempted = (prefs.getStringSet(KEY_ATTEMPTED, emptySet()) ?: emptySet()).toMutableSet()
                attempted.add(id)
                editor.putStringSet(KEY_ATTEMPTED, attempted)
            }
        }
        editor.apply()
    }
}
