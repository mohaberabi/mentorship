package dao

import com.mohaberabi.model.WeaknessModel
import com.mohaberabi.sourc.WeaknessLocalDataSource
import entity.toEntity
import entity.toWeaknessModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class RoomWeaknessLocalDataSource @Inject constructor(
    private val dao: WeaknessDao,
) : WeaknessLocalDataSource {


    override suspend fun addWeakness(weakness: WeaknessModel) {
        dao.upsertWeakness(weakness.toEntity())
    }

    override fun getAllWeakness(): Flow<List<WeaknessModel>> {

        return dao.getAllWeakness().map { list -> list.map { it.toWeaknessModel() } }
    }


}