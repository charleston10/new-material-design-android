package br.com.charleston.doghero.features.heroes.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import br.com.charleston.doghero.R

class DataBindingAdapter {

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["url"], requireAll = false)
        fun setImageUrl(view: ImageView, url: String) {
            Glide
                .with(view.context)
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .into(view)
        }

        @JvmStatic
        @BindingAdapter(value = ["currency"], requireAll = false)
        fun formatCurrency(view: TextView, value: Double) {
            view.text = String.format(view.context.getString(R.string.my_hero_price), value.toInt())
        }
    }
}