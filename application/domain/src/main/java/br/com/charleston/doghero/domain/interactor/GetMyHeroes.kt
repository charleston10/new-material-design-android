package br.com.charleston.doghero.domain.interactor

import br.com.charleston.doghero.domain.UseCase
import br.com.charleston.doghero.domain.executor.PostExecutionThread
import br.com.charleston.doghero.domain.executor.ThreadExecutor
import br.com.charleston.doghero.domain.model.HeroModel
import br.com.charleston.doghero.domain.repository.HeroRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetMyHeroes @Inject constructor(
    private val heroRepository: HeroRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCase<List<HeroModel>, Void>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Void?): Observable<List<HeroModel>> {
        return heroRepository
            .getHeroes()
    }
}