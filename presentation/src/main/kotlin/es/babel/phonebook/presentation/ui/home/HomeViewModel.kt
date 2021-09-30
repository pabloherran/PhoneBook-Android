package es.babel.phonebook.presentation.ui.home

import es.babel.phonebook.presentation.base.BaseViewModel

class HomeViewModel : BaseViewModel<HomeState, HomeNavigator.Navigation>() {

    override val initialViewState: HomeState = HomeState()

    override fun onResume(firstTime: Boolean) {

    }

    override fun onStartFirstTime(statePreloaded: Boolean) {
        val championList = listOf(HomeAdapter.ChampionItem("Teemo"))
        updateToNormalState {
            copy(championList = championList)
        }
    }

    fun onActionChampionClicked() {
        navigate(HomeNavigator.Navigation.FromHomeToChampion)
    }


}