package br.com.charleston.doghero.features.heroes.screens

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.charleston.doghero.R
import br.com.charleston.doghero.core.base.BaseFragment
import br.com.charleston.doghero.databinding.FragmentMyHeroesBinding
import br.com.charleston.doghero.features.heroes.adapters.HeroData
import br.com.charleston.doghero.features.heroes.adapters.HeroesAdapter
import br.com.charleston.doghero.features.heroes.data.HeroState
import br.com.charleston.doghero.features.heroes.viewmodel.HeroViewModel
import com.google.android.material.snackbar.Snackbar

class MyHeroesFragment : BaseFragment<FragmentMyHeroesBinding, HeroViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerViewModel()
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
        getViewModel().input.showHeroes()
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

    private fun bindItems(items: List<HeroData>) {
        getViewDataBinding().listHeroes.apply {
            adapter = HeroesAdapter(items)
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun showLoading() {
        getViewDataBinding().isLoading = true
    }

    private fun hideLoading() {
        getViewDataBinding().isLoading = false
    }

    private fun showError() {
        Snackbar.make(
            activity!!.findViewById(android.R.id.content),
            "Falha ao obter dados\nTente novamente mais tarde.",
            Snackbar.LENGTH_LONG
        ).setActionTextColor(Color.RED).show()
    }
}