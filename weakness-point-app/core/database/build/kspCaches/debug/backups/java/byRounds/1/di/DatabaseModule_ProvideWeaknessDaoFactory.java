package di;

import com.mohaberabi.sourc.WeaknessLocalDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import db.WeaknessDatabase;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DatabaseModule_ProvideWeaknessDaoFactory implements Factory<WeaknessLocalDataSource> {
  private final Provider<WeaknessDatabase> dbProvider;

  public DatabaseModule_ProvideWeaknessDaoFactory(Provider<WeaknessDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public WeaknessLocalDataSource get() {
    return provideWeaknessDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideWeaknessDaoFactory create(
      Provider<WeaknessDatabase> dbProvider) {
    return new DatabaseModule_ProvideWeaknessDaoFactory(dbProvider);
  }

  public static WeaknessLocalDataSource provideWeaknessDao(WeaknessDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideWeaknessDao(db));
  }
}
