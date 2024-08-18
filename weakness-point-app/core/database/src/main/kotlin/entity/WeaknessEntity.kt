package entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mohaberabi.model.WeaknessModel


@Entity("weakness")
data class WeaknessEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val title: String,
)

fun WeaknessEntity.toWeaknessModel(
): WeaknessModel = WeaknessModel(
    title = title,
    id = id
)

fun WeaknessModel.toEntity(
): WeaknessEntity = WeaknessEntity(
    title = title,
    id = id
)

