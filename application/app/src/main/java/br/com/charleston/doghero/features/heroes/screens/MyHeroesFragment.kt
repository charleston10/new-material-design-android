package br.com.charleston.doghero.features.heroes.screens

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.charleston.doghero.R
import br.com.charleston.doghero.core.base.BaseFragment
import br.com.charleston.doghero.databinding.FragmentMyHeroesBinding
import br.com.charleston.doghero.features.heroes.data.HeroData
import br.com.charleston.doghero.features.heroes.adapters.HeroesAdapter
import br.com.charleston.doghero.features.heroes.data.HeroState
import br.com.charleston.doghero.features.heroes.viewmodel.HeroViewModel
import com.google.android.material.snackbar.Snackbar


class MyHeroesFragment : BaseFragment<FragmentMyHeroesBinding, HeroViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindToolbar()
        observerViewModel()
        fetchData()
        bindRefreshLayout()
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
                hideLoading()
                bindItems(state.data)
            }
            is HeroState.Error -> {
                hideLoading()
                showError()
            }
        }
    }

    private fun bindToolbar() {
        getViewDataBinding().toolbar.apply {
            title = "Meus Heróis"
        }

        (activity as AppCompatActivity)
            .setSupportActionBar(getViewDataBinding().toolbar)
    }

    private fun bindItems(items: List<HeroData>) {
        getViewDataBinding().listHeroes.apply {
            adapter = HeroesAdapter(context, items)
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun bindRefreshLayout() {
        getViewDataBinding().refreshLayout.setOnRefreshListener { fetchData() }
    }

    private fun showLoading() {
        getViewDataBinding().isLoading = true
        getViewDataBinding().refreshLayout.isRefreshing = true
    }

    private fun hideLoading() {
        getViewDataBinding().isLoading = false
        getViewDataBinding().refreshLayout.isRefreshing = false
    }

    private fun showError() {
        Snackbar.make(
            activity!!.findViewById(android.R.id.content),
            getString(R.string.my_heroes_error),
            Snackbar.LENGTH_LONG
        ).setActionTextColor(Color.RED).show()
    }
}