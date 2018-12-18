package br.com.charleston.doghero.data.repository.datasource.cloud

import br.com.charleston.doghero.data.cloud.requests.HeroesApi
import br.com.charleston.doghero.data.cloud.responses.mapper.HeroCloudMapper
import br.com.charleston.doghero.domain.model.HeroModel
import io.reactivex.Observable

class HeroCloudDataStore(
    private val heroesApi: HeroesApi,
    private val mapper: HeroCloudMapper
) : IHeroCloudDataStore {

    override fun getHeroes(): Observable<List<HeroModel>> {
        return heroesApi.getMyHeroes()
            .map { listResponse ->
                listResponse.map { mapper.transform(it) }
            }
    }
}