package br.com.charleston.doghero.data.repository.datasource.cloud

import br.com.charleston.doghero.data.cloud.requests.HeroesApi
import br.com.charleston.doghero.data.cloud.responses.mapper.HeroCloudMapper
import br.com.charleston.doghero.domain.model.DataHeroesModel
import io.reactivex.Observable

class HeroCloudDataStore(
    private val heroesApi: HeroesApi,
    private val mapper: HeroCloudMapper
) : IHeroCloudDataStore {

    override fun getHeroes(): Observable<DataHeroesModel> {
        return heroesApi.getMyHeroes()
            .map {
                mapper.transform(it)
            }
    }
}