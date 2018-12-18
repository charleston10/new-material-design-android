package br.com.charleston.doghero.data.repository

import br.com.charleston.doghero.data.repository.datasource.cloud.HeroCloudDataStore
import br.com.charleston.doghero.domain.model.DataHeroesModel
import br.com.charleston.doghero.domain.repository.IHeroRepository
import io.reactivex.Observable

class HeroDataRepository(
    private val cloudDataStore: HeroCloudDataStore
) : IHeroRepository {

    override fun getHeroes(): Observable<DataHeroesModel> {
        return cloudDataStore.getHeroes()
    }
}