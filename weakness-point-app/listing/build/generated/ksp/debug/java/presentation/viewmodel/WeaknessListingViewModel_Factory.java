package presentation.viewmodel;

import com.mohaberabi.repository.WeaknessRepository;
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
public final class WeaknessListingViewModel_Factory implements Factory<WeaknessListingViewModel> {
  private final Provider<WeaknessRepository> weaknessRepositoryProvider;

  public WeaknessListingViewModel_Factory(Provider<WeaknessRepository> weaknessRepositoryProvider) {
    this.weaknessRepositoryProvider = weaknessRepositoryProvider;
  }

  @Override
  public WeaknessListingViewModel get() {
    return newInstance(weaknessRepositoryProvider.get());
  }

  public static WeaknessListingViewModel_Factory create(
      Provider<WeaknessRepository> weaknessRepositoryProvider) {
    return new WeaknessListingViewModel_Factory(weaknessRepositoryProvider);
  }

  public static WeaknessListingViewModel newInstance(WeaknessRepository weaknessRepository) {
    return new WeaknessListingViewModel(weaknessRepository);
  }
}
