package br.com.charleston.doghero.data.cloud.responses.mapper

import br.com.charleston.doghero.data.cloud.responses.DataResponse
import br.com.charleston.doghero.data.cloud.responses.HeroResponse
import br.com.charleston.doghero.data.cloud.responses.UserResponse
import br.com.charleston.doghero.data.repository.Mapper
import br.com.charleston.doghero.domain.model.DataHeroesModel
import br.com.charleston.doghero.domain.model.HeroModel
import br.com.charleston.doghero.domain.model.UserModel
import java.lang.ref.WeakReference

class HeroCloudMapper : Mapper<DataResponse, DataHeroesModel> {

    override fun transform(entity: DataResponse): DataHeroesModel {
        val heroMapper: WeakReference<HeroMapper> = WeakReference(HeroMapper())

        return DataHeroesModel(
            recents = entity.recents.map { heroMapper.get()!!.transform(it) },
            favorites = entity.favorites.map { heroMapper.get()!!.transform(it) }
        )
    }

    private inner class HeroMapper : Mapper<HeroResponse, HeroModel> {
        override fun transform(entity: HeroResponse): HeroModel {
            val userMapper: WeakReference<UserMapper> = WeakReference(UserMapper())

            return HeroModel(
                isSuperHero = entity.isSuperHero,
                addressNeighborhood = entity.addressNeighborhood,
                price = entity.price,
                user = userMapper.get()!!.transform(entity.user)
            )
        }
    }

    private inner class UserMapper : Mapper<UserResponse, UserModel> {
        override fun transform(entity: UserResponse): UserModel {
            return UserModel(
                entity.firstName,
                entity.imageUrl
            )
        }
    }
}