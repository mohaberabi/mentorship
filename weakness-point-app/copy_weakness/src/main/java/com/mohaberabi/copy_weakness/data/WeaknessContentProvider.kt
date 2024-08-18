package com.mohaberabi.copy_weakness.data

import com.mohaberabi.model.WeaknessModel


import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri


class WeaknessContentProvider : ContentProvider() {

    companion object {
        private const val ID = "_id"
        private const val TITLE = "title"
        private val columnNames = arrayOf(ID, TITLE)
        private const val AUTHORITY = "com.mohaberabi.weaknesspointapp.feature.copy_weakness"
        private const val MILESTONES = 1
        private const val MILESTONE_ID = 2
        private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
            addURI(AUTHORITY, "weakness", MILESTONES)
            addURI(AUTHORITY, "weakness/#", MILESTONE_ID)
        }
    }

    private lateinit var milestones: MutableMap<Long, WeaknessModel>
    override fun onCreate(): Boolean {
        milestones = DummyData.milestones.toMutableMap()
        return true
    }

    override fun insert(
        uri: Uri,
        values: ContentValues?,
    ): Uri {
        val id = milestones.size + 1L
        val mileStone = WeaknessModel(
            id = id,
            title = values?.getAsString(TITLE) ?: "",
        )
        milestones[id] = mileStone
        return ContentUris.withAppendedId(uri, id)
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor {
        when (uriMatcher.match(uri)) {
            MILESTONES -> {
                val curser = MatrixCursor(
                    columnNames,
                )
                milestones.values.forEach {
                    curser.addRow(
                        arrayOf(
                            it.id,
                            it.title,
                        )
                    )
                }
                return curser
            }

            else -> throw IllegalArgumentException("Unknown URI: $uri")
        }

    }


    override fun delete(
        uri: Uri,
        selection: String?,
        args: Array<out String>?,
    ): Int {
        val id = ContentUris.parseId(uri)
        milestones.remove(id)
        return 1
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        args: Array<out String>?,
    ): Int {
        val id = ContentUris.parseId(uri)
        val milestone = milestones[id] ?: return 0
        val updatedMilestone = milestone.copy(
            id = values?.getAsLong(ID) ?: 0L,
            title = values?.getAsString(TITLE) ?: milestone.title,
        )
        milestones[id] = updatedMilestone
        return 1
    }


    override fun getType(uri: Uri): String? {
        return null
    }

}