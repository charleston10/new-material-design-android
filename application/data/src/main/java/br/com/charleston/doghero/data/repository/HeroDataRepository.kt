package br.com.charleston.doghero.data.repository

import br.com.charleston.doghero.domain.repository.HeroRepository
import br.com.charleston.doghero.data.repository.datasource.cloud.HeroCloudDataStore
import br.com.charleston.doghero.domain.model.HeroModel
import io.reactivex.Observable

class HeroDataRepository(
    private val cloudDataStore: HeroCloudDataStore
) : HeroRepository {

    override fun getHeroes(): Observable<List<HeroModel>> {
        return cloudDataStore.getHeroes()
    }
}