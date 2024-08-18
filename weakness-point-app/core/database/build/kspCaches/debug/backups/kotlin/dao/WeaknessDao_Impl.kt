package dao

import android.database.Cursor
import androidx.room.CoroutinesRoom
import androidx.room.EntityDeletionOrUpdateAdapter
import androidx.room.EntityInsertionAdapter
import androidx.room.EntityUpsertionAdapter
import androidx.room.RoomDatabase
import androidx.room.RoomSQLiteQuery
import androidx.room.RoomSQLiteQuery.Companion.acquire
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.query
import androidx.sqlite.db.SupportSQLiteStatement
import entity.WeaknessEntity
import java.lang.Class
import java.util.ArrayList
import java.util.concurrent.Callable
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION"])
public class WeaknessDao_Impl(
  __db: RoomDatabase,
) : WeaknessDao {
  private val __db: RoomDatabase

  private val __upsertionAdapterOfWeaknessEntity: EntityUpsertionAdapter<WeaknessEntity>
  init {
    this.__db = __db
    this.__upsertionAdapterOfWeaknessEntity = EntityUpsertionAdapter<WeaknessEntity>(object :
        EntityInsertionAdapter<WeaknessEntity>(__db) {
      protected override fun createQuery(): String =
          "INSERT INTO `weakness` (`id`,`title`) VALUES (?,?)"

      protected override fun bind(statement: SupportSQLiteStatement, entity: WeaknessEntity) {
        val _tmpId: Long? = entity.id
        if (_tmpId == null) {
          statement.bindNull(1)
        } else {
          statement.bindLong(1, _tmpId)
        }
        statement.bindString(2, entity.title)
      }
    }, object : EntityDeletionOrUpdateAdapter<WeaknessEntity>(__db) {
      protected override fun createQuery(): String =
          "UPDATE `weakness` SET `id` = ?,`title` = ? WHERE `id` = ?"

      protected override fun bind(statement: SupportSQLiteStatement, entity: WeaknessEntity) {
        val _tmpId: Long? = entity.id
        if (_tmpId == null) {
          statement.bindNull(1)
        } else {
          statement.bindLong(1, _tmpId)
        }
        statement.bindString(2, entity.title)
        val _tmpId_1: Long? = entity.id
        if (_tmpId_1 == null) {
          statement.bindNull(3)
        } else {
          statement.bindLong(3, _tmpId_1)
        }
      }
    })
  }

  public override suspend fun upsertWeakness(weakness: WeaknessEntity): Unit =
      CoroutinesRoom.execute(__db, true, object : Callable<Unit> {
    public override fun call() {
      __db.beginTransaction()
      try {
        __upsertionAdapterOfWeaknessEntity.upsert(weakness)
        __db.setTransactionSuccessful()
      } finally {
        __db.endTransaction()
      }
    }
  })

  public override fun getAllWeakness(): Flow<List<WeaknessEntity>> {
    val _sql: String = "SELECT * FROM weakness"
    val _statement: RoomSQLiteQuery = acquire(_sql, 0)
    return CoroutinesRoom.createFlow(__db, false, arrayOf("weakness"), object :
        Callable<List<WeaknessEntity>> {
      public override fun call(): List<WeaknessEntity> {
        val _cursor: Cursor = query(__db, _statement, false, null)
        try {
          val _cursorIndexOfId: Int = getColumnIndexOrThrow(_cursor, "id")
          val _cursorIndexOfTitle: Int = getColumnIndexOrThrow(_cursor, "title")
          val _result: MutableList<WeaknessEntity> = ArrayList<WeaknessEntity>(_cursor.getCount())
          while (_cursor.moveToNext()) {
            val _item: WeaknessEntity
            val _tmpId: Long?
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId)
            }
            val _tmpTitle: String
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle)
            _item = WeaknessEntity(_tmpId,_tmpTitle)
            _result.add(_item)
          }
          return _result
        } finally {
          _cursor.close()
        }
      }

      protected fun finalize() {
        _statement.release()
      }
    })
  }

  public companion object {
    @JvmStatic
    public fun getRequiredConverters(): List<Class<*>> = emptyList()
  }
}
