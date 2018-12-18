package br.com.charleston.doghero.data.repository.datasource.cloud

import br.com.charleston.doghero.domain.model.HeroModel
import io.reactivex.Observable

interface IHeroCloudDataStore {
    fun getHeroes(): Observable<List<HeroModel>>
}