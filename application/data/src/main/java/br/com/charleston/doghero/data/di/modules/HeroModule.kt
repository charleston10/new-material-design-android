package br.com.charleston.doghero.data.di.modules

import br.com.charleston.doghero.data.cloud.requests.HeroesApi
import br.com.charleston.doghero.data.cloud.responses.mapper.HeroCloudMapper
import br.com.charleston.doghero.data.repository.HeroDataRepository
import br.com.charleston.doghero.data.repository.datasource.cloud.HeroCloudDataStore
import br.com.charleston.doghero.domain.repository.IHeroRepository
import dagger.Module
import dagger.Provides

@Module
class HeroModule {

    @Provides
    fun cloudMapper(): HeroCloudMapper {
        return HeroCloudMapper()
    }

    @Provides
    fun questionCloudDataStore(
        heroesApi: HeroesApi,
        mapper: HeroCloudMapper
    ): HeroCloudDataStore {
        return HeroCloudDataStore(heroesApi, mapper)
    }

    @Provides
    fun questionDataRepository(
        cloud: HeroCloudDataStore
    ): IHeroRepository {
        return HeroDataRepository(cloud)
    }
}