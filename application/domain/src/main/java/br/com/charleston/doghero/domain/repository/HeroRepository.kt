package br.com.charleston.doghero.domain.repository

import br.com.charleston.doghero.domain.model.HeroModel
import io.reactivex.Observable

interface HeroRepository {
    fun getHeroes(): Observable<List<HeroModel>>
}