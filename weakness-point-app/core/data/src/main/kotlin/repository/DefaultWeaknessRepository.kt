package repository

import com.mohaberabi.model.WeaknessModel
import com.mohaberabi.repository.WeaknessRepository
import kotlinx.coroutines.flow.Flow

import com.mohaberabi.sourc.WeaknessLocalDataSource
import com.myfitnessbag.order.core.util.AppResult
import com.myfitnessbag.order.core.util.EmptyDataResult
import com.myfitnessbag.order.core.util.error.ErrorModel

import javax.inject.Inject

class DefaultWeaknessRepository @Inject constructor(
    private val weaknessLocalDataSource: WeaknessLocalDataSource,
) : WeaknessRepository {

    override fun getAllWeakness(): Flow<List<WeaknessModel>> =
        weaknessLocalDataSource.getAllWeakness()

    override suspend fun addWeakness(weakness: WeaknessModel): EmptyDataResult<ErrorModel> {
        return AppResult.handle {
            weaknessLocalDataSource.addWeakness(weakness)
        }
    }


}