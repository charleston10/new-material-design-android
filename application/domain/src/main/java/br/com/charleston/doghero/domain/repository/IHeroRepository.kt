package br.com.charleston.doghero.domain.repository

import br.com.charleston.doghero.domain.model.DataHeroesModel
import io.reactivex.Observable

interface IHeroRepository {
    fun getHeroes(): Observable<DataHeroesModel>
}