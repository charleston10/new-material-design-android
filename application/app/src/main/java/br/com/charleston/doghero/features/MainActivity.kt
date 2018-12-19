package br.com.charleston.doghero.features

import androidx.lifecycle.ViewModelProviders
import br.com.charleston.doghero.R
import br.com.charleston.doghero.core.base.BaseActivity
import br.com.charleston.doghero.core.base.BaseViewModel
import br.com.charleston.doghero.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): BaseViewModel {
        return ViewModelProviders
            .of(this, viewModelFactory)
            .get(BaseViewModel::class.java)
    }
}