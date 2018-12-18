package br.com.charleston.doghero.data.cloud

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
class NetworkModule {

    @Provides
    fun okHttpClient(
        @Named(USER_AGENT_INTERCEPTOR) userAgentInterceptor: Interceptor,
        @Named(RESPONSE_INTERCEPTOR) responseInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(userAgentInterceptor)
            .addInterceptor(responseInterceptor)
            .build()
    }

    @Provides
    fun retrofitBuilder(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    @Provides
    fun retrofit(
        @Named(URL_DOMAIN) urlDomain: String,
        retrofitBuilder: Retrofit.Builder
    ): Retrofit {
        return retrofitBuilder
            .baseUrl(urlDomain)
            .build()
    }

    @Provides
    fun gsonFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(GsonBuilder().create())
    }
}