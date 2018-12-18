package br.com.charleston.doghero.data.cloud.requests

import br.com.charleston.doghero.data.cloud.responses.DataResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface HeroesApi {

    @GET("myheroes.txt")
    fun getMyHeroes(): Observable<DataResponse>
}
