package es.babel.phonebook.presentation.ui.champion

import es.babel.phonebook.presentation.base.BaseViewModel
import es.babel.phonebook.presentation.ui.home.HomeNavigator

class ChampionViewModel : BaseViewModel<ChampionState, ChampionNavigator.Navigation>(){

    override val initialViewState: ChampionState = ChampionState()

    override fun onResume(firstTime: Boolean) {

    }

    override fun onStartFirstTime(statePreloaded: Boolean) {
        
    }


}