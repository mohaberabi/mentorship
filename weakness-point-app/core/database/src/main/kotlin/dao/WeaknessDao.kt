package dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import entity.WeaknessEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeaknessDao {


    @Upsert
    suspend fun upsertWeakness(weakness: WeaknessEntity)

    @Query("SELECT * FROM weakness")
    fun getAllWeakness(): Flow<List<WeaknessEntity>>
}