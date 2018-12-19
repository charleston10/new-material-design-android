package br.com.charleston.doghero.features.heroes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import br.com.charleston.doghero.R
import br.com.charleston.doghero.domain.model.HeroModel

class HeroesAdapter(
    private val items: List<HeroData>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_HERO = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layout = if (viewType == TYPE_HEADER) R.layout.item_my_hero_header else R.layout.item_my_hero
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ViewDataBinding>(inflater, layout, parent, false)

        return if (viewType == TYPE_HEADER) {
            HeaderViewHolder(view)
        } else {
            HeroesViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (getItemViewType(position) == TYPE_HEADER) {
            (holder as HeaderViewHolder).bind(item.heroType)
        } else {
            (holder as HeroesViewHolder).bind(item.hero!!)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].dataType == HeroData.DataType.HEADER) {
            TYPE_HEADER
        } else {
            TYPE_HERO
        }
    }

    inner class HeroesViewHolder(
        private val viewDataBinding: ViewDataBinding
    ) : RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(data: HeroModel) {
            viewDataBinding.setVariable(BR.hero, data)
            viewDataBinding.executePendingBindings()
        }
    }

    inner class HeaderViewHolder(
        private val viewDataBinding: ViewDataBinding
    ) : RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(type: HeroData.HeroType) {
            val title = when (type) {
                HeroData.HeroType.RECENT -> "Heróis com que hospedei"
                else -> "Heróis favoritos"
            }
            viewDataBinding.setVariable(BR.title, title)
            viewDataBinding.executePendingBindings()
        }
    }
}