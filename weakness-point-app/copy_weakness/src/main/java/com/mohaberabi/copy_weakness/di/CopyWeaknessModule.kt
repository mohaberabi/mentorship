package com.mohaberabi.copy_weakness.di

import android.content.Context
import com.mohaberabi.copy_weakness.data.WeaknessContentResolverCursor
import com.mohaberabi.copy_weakness.domain.AppContentProviderCursor
import com.mohaberabi.model.WeaknessModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CopyWeaknessModule {
    @Provides
    @Singleton
    fun provideAppCursor(
        @ApplicationContext context: Context,
    ): AppContentProviderCursor<WeaknessModel> =
        WeaknessContentResolverCursor(context)


}