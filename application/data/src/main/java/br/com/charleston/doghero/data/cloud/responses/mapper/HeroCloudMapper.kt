package br.com.charleston.doghero.data.cloud.responses.mapper

import br.com.charleston.doghero.data.cloud.responses.HeroResponse
import br.com.charleston.doghero.data.cloud.responses.UserResponse
import br.com.charleston.doghero.data.repository.Mapper
import br.com.charleston.doghero.domain.model.HeroModel
import br.com.charleston.doghero.domain.model.UserModel
import java.lang.ref.WeakReference

class HeroCloudMapper : Mapper<HeroResponse, HeroModel> {

    override fun transform(entity: HeroResponse): HeroModel {
        val userMapper: WeakReference<UserMapper> = WeakReference(UserMapper())

        return HeroModel(
            isSuperHero = entity.isSuperHero,
            addressNeighborhood = entity.addressNeighborhood,
            price = entity.price,
            user = userMapper.get()!!.transform(entity.user)//always reference because this(!!)
        )
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