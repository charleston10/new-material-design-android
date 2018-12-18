package br.com.charleston.doghero.data.cloud

import br.com.charleston.doghero.data.cloud.requests.HeroesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RequestModule {

    @Provides
    fun provideQuestionApi(retrofit: Retrofit): HeroesApi {
        return retrofit.create(HeroesApi::class.java)
    }
}