package br.com.charleston.doghero.features.heroes.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AvatarBindingAdapter {

    companion object {
        @JvmStatic
        @BindingAdapter("app:imageUrl")
        fun setImageUrl(view: ImageView, url: String) {
            Glide
                .with(view.context)
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .into(view)
        }
    }
}