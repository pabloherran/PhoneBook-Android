package es.babel.phonebook.presentation.base

import es.babel.easymvvm.android.ui.EmaFragment
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.core.state.EmaBaseState
import es.babel.phonebook.presentation.di.generateFragmentModule
import org.kodein.di.Kodein

abstract class BaseFragment<S : EmaBaseState, VM : BaseViewModel<S, NS>, NS : EmaNavigationState> :
    EmaFragment<S, VM, NS>() {

    override val fragmentViewModelScope = true

    override fun injectFragmentModule(kodein: Kodein.MainBuilder) =
        generateFragmentModule(fragment = this)

}
