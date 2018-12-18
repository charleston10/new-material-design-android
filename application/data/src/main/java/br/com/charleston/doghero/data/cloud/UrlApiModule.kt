package br.com.charleston.doghero.data.cloud

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
open class UrlApiModule {

    @Provides
    @Named(URL_DOMAIN)
    open fun provideUrl(): String {
        return "https://raw.githubusercontent.com/charleston10/dog-hero-android/master/api/"
    }
}