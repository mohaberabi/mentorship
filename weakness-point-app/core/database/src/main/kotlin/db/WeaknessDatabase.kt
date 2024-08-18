package db

import androidx.room.Database
import androidx.room.RoomDatabase
import dao.WeaknessDao
import entity.WeaknessEntity

@Database(
    entities = [WeaknessEntity::class],
    version = 1,
)
abstract class WeaknessDatabase : RoomDatabase() {

    companion object {
        const val App_DB_NAME = "weakness.db"
    }

    abstract fun weaknessDao(): WeaknessDao
}