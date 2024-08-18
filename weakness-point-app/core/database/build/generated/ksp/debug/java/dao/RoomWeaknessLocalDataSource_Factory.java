package dao;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class RoomWeaknessLocalDataSource_Factory implements Factory<RoomWeaknessLocalDataSource> {
  private final Provider<WeaknessDao> daoProvider;

  public RoomWeaknessLocalDataSource_Factory(Provider<WeaknessDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public RoomWeaknessLocalDataSource get() {
    return newInstance(daoProvider.get());
  }

  public static RoomWeaknessLocalDataSource_Factory create(Provider<WeaknessDao> daoProvider) {
    return new RoomWeaknessLocalDataSource_Factory(daoProvider);
  }

  public static RoomWeaknessLocalDataSource newInstance(WeaknessDao dao) {
    return new RoomWeaknessLocalDataSource(dao);
  }
}
