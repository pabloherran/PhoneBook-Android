package es.babel.phonebook.presentation.ui.main

import es.babel.easymvvm.android.extra.EmaReceiverModel
import es.babel.easymvvm.android.extra.EmaResultModel
import es.babel.easymvvm.android.ui.EmaView
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.phonebook.presentation.R
import es.babel.phonebook.presentation.base.BaseActivity
import org.kodein.di.generic.instance

class MainViewActivity : BaseActivity(),
    EmaView<MainViewState, MainViewModel, MainNavigator.Navigation> {

    override val viewModelSeed: MainViewModel by instance<MainViewModel>()

    override val navigator: EmaBaseNavigator<MainNavigator.Navigation>?
            by instance<EmaBaseNavigator<MainNavigator.Navigation>>()

    override val inputState: MainViewState? by instance<MainViewState>()

    override var previousState: MainViewState? = null

    override val layoutId: Int = R.layout.activity_main

    override val navGraph: Int = R.navigation.navigation_main

    private lateinit var viewModel: MainViewModel

    override fun onResultReceiverInvokeEvent(emaReceiverModel: EmaReceiverModel) {
        //Nothing to do
    }

    override fun onResultSetEvent(emaResultModel: EmaResultModel) {
        //Nothing to do
    }

    override fun onSingleEvent(data: EmaExtraData) {
        //Nothing to do
    }

    override fun onStateAlternative(data: EmaExtraData) {
        //Nothing to do
    }

    override fun onStateError(error: Throwable) {
        //Nothing to do
    }

    override fun onStateNormal(data: MainViewState) {
        //Nothing to do
    }

    override fun onViewModelInitialized(viewModel: MainViewModel) {
        this.viewModel = viewModel
    }

}
