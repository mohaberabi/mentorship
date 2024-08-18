package di;

import com.myfitnessbag.order.core.util.DispatchersProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class DatabaseModule_ProvideAppDispatchersFactory implements Factory<DispatchersProvider> {
  @Override
  public DispatchersProvider get() {
    return provideAppDispatchers();
  }

  public static DatabaseModule_ProvideAppDispatchersFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DispatchersProvider provideAppDispatchers() {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideAppDispatchers());
  }

  private static final class InstanceHolder {
    private static final DatabaseModule_ProvideAppDispatchersFactory INSTANCE = new DatabaseModule_ProvideAppDispatchersFactory();
  }
}
