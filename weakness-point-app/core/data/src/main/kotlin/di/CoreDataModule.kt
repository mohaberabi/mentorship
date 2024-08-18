package di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.mohaberabi.repository.WeaknessRepository
import repository.DefaultWeaknessRepository


@InstallIn(SingletonComponent::class)
@Module
abstract class CoreDataModule {


    @Binds
    abstract fun bindWeaknessRepository(
        impl: DefaultWeaknessRepository,
    ): WeaknessRepository


}




