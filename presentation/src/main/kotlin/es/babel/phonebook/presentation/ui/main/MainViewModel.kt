package es.babel.phonebook.presentation.ui.main

import es.babel.easymvvm.android.viewmodel.EmaViewModel

class MainViewModel : EmaViewModel<MainViewState, MainNavigator.Navigation>() {

    override val initialViewState: MainViewState = MainViewState()

    override fun onResume(firstTime: Boolean) {
        //Nothing to do
    }

    override fun onStartFirstTime(statePreloaded: Boolean) {
        //Nothing to do
    }

}
