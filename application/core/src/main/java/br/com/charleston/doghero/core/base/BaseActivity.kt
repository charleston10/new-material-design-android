package br.com.charleston.doghero.core.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel>
    : AppCompatActivity(), HasSupportFragmentInjector {

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private val dataBinding: T by lazy { DataBindingUtil.setContentView<T>(this, getLayoutId()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        executeDataBinding()
    }

    override fun onDestroy() {
        super.onDestroy()
        getViewModel().onDestroyView()
    }

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    fun getViewDataBinding(): T {
        return dataBinding
    }

    private fun executeDataBinding() {
        dataBinding.executePendingBindings()
    }
}