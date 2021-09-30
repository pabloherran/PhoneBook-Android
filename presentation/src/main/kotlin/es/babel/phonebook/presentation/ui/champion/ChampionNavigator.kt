package es.babel.phonebook.presentation.ui.champion

import androidx.navigation.NavController
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

class ChampionNavigator(val navController: NavController): EmaBaseNavigator<ChampionNavigator.Navigation> {
    sealed class Navigation : EmaNavigationState

    override fun navigateBack(): Boolean {
        return true
    }
}