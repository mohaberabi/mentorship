package repository;

import com.mohaberabi.sourc.WeaknessLocalDataSource;
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
public final class DefaultWeaknessRepository_Factory implements Factory<DefaultWeaknessRepository> {
  private final Provider<WeaknessLocalDataSource> weaknessLocalDataSourceProvider;

  public DefaultWeaknessRepository_Factory(
      Provider<WeaknessLocalDataSource> weaknessLocalDataSourceProvider) {
    this.weaknessLocalDataSourceProvider = weaknessLocalDataSourceProvider;
  }

  @Override
  public DefaultWeaknessRepository get() {
    return newInstance(weaknessLocalDataSourceProvider.get());
  }

  public static DefaultWeaknessRepository_Factory create(
      Provider<WeaknessLocalDataSource> weaknessLocalDataSourceProvider) {
    return new DefaultWeaknessRepository_Factory(weaknessLocalDataSourceProvider);
  }

  public static DefaultWeaknessRepository newInstance(
      WeaknessLocalDataSource weaknessLocalDataSource) {
    return new DefaultWeaknessRepository(weaknessLocalDataSource);
  }
}
