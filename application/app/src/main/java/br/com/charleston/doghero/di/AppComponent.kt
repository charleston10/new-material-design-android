package br.com.charleston.doghero.di

import android.app.Application
import br.com.charleston.doghero.AndroidApplication
import br.com.charleston.doghero.core.di.modules.AndroidModule
import br.com.charleston.doghero.core.di.modules.FactoryModule
import br.com.charleston.doghero.data.cloud.InterceptorModule
import br.com.charleston.doghero.data.cloud.NetworkModule
import br.com.charleston.doghero.data.cloud.RequestModule
import br.com.charleston.doghero.data.cloud.UrlApiModule
import br.com.charleston.doghero.data.di.modules.HeroModule
import br.com.charleston.doghero.di.modules.ActivityModule
import br.com.charleston.doghero.di.modules.FragmentModule
import br.com.charleston.doghero.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        FactoryModule::class,
        AndroidModule::class,
        ActivityModule::class,
        FragmentModule::class,
        ViewModelModule::class,
        InterceptorModule::class,
        NetworkModule::class,
        RequestModule::class,
        UrlApiModule::class,
        HeroModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: AndroidApplication)
}