package br.com.charleston.doghero.domain.interactor

import br.com.charleston.doghero.domain.UseCase
import br.com.charleston.doghero.domain.executor.PostExecutionThread
import br.com.charleston.doghero.domain.executor.ThreadExecutor
import br.com.charleston.doghero.domain.model.DataHeroesModel
import br.com.charleston.doghero.domain.repository.IHeroRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetMyHeroes @Inject constructor(
    private val repository: IHeroRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCase<DataHeroesModel, Void>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Void?): Observable<DataHeroesModel> {
        return repository.getHeroes()
    }
}