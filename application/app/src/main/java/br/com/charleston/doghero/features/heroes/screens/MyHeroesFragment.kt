package br.com.charleston.doghero.features.heroes.screens

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.charleston.doghero.R
import br.com.charleston.doghero.core.base.BaseFragment
import br.com.charleston.doghero.databinding.FragmentMyHeroesBinding
import br.com.charleston.doghero.features.heroes.adapters.HeroesAdapter
import br.com.charleston.doghero.features.heroes.adapters.LastSpaceItemDecoration
import br.com.charleston.doghero.features.heroes.data.HeroData
import br.com.charleston.doghero.features.heroes.data.HeroState
import br.com.charleston.doghero.features.heroes.viewmodel.HeroViewModel
import java.util.*

class MyHeroesFragment : BaseFragment<FragmentMyHeroesBinding, HeroViewModel>() {

    private var adapter: HeroesAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerViewModel()
        bindToolbar()
        bindRefreshLayout()
        fetchData()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_my_heroes
    }

    override fun getViewModel(): HeroViewModel {
        return ViewModelProviders
            .of(this, viewModelFactory)
            .get(HeroViewModel::class.java)
    }


    private fun fetchData() {
        getViewModel().input.fetchHeroes()
    }

    private fun observerViewModel() {
        getViewModel().output
            .heroes.observe(this,
            Observer {
                renderHeroState(it)
            })
    }

    private fun renderHeroState(state: HeroState) {
        when (state) {
            is HeroState.Loading -> {
                showLoading()
            }
            is HeroState.Success -> {
                showLoading(false)
                showError(false)
                bindItems(state.data)
            }
            is HeroState.Error -> {
                showLoading(false)
                showError()
            }
        }
    }

    private fun bindToolbar() {
        getViewDataBinding().toolbar.apply {
            title = context.getString(R.string.my_heroes_title)
        }

        (activity as AppCompatActivity)
            .setSupportActionBar(getViewDataBinding().toolbar)
    }

    private fun bindItems(items: List<HeroData>) {
        if (adapter == null) {
            adapter = HeroesAdapter(context!!, ArrayList(items))

            getViewDataBinding().listHeroes.apply {
                adapter = this@MyHeroesFragment.adapter
                layoutManager = LinearLayoutManager(context)
                addItemDecoration(LastSpaceItemDecoration())
            }
        } else {
            adapter?.updateAll(items)
        }
    }

    private fun bindRefreshLayout() {
        getViewDataBinding().refreshLayout.setOnRefreshListener {
            fetchData()
        }
    }

    private fun showLoading(isLoading: Boolean = true) {
        getViewDataBinding().isLoading = isLoading
        getViewDataBinding().refreshLayout.isRefreshing = isLoading
    }

    private fun showError(isError: Boolean = true) {
        getViewDataBinding().isError = isError
    }
}