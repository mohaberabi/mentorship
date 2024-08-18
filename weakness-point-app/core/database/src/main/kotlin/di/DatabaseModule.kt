package di

import android.content.Context
import androidx.room.Room
import com.mohaberabi.sourc.WeaknessLocalDataSource
import com.myfitnessbag.order.core.util.DefaultDispatcherProvider
import com.myfitnessbag.order.core.util.DispatchersProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dao.RoomWeaknessLocalDataSource
import db.WeaknessDatabase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context,
    ): WeaknessDatabase = Room.databaseBuilder(
        context,
        WeaknessDatabase::class.java,
        WeaknessDatabase.App_DB_NAME
    ).build()


    @Singleton
    @Provides
    fun provideWeaknessDao(
        db: WeaknessDatabase,
    ): WeaknessLocalDataSource = RoomWeaknessLocalDataSource(
        dao = db.weaknessDao()
    )

    @Singleton
    @Provides
    fun provideAppDispatchers(
    ): DispatchersProvider = DefaultDispatcherProvider(

    )

}