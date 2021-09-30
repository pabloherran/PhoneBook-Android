package es.babel.phonebook.presentation.ui.home

import androidx.navigation.NavController
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.phonebook.presentation.R

class HomeNavigator(override val navController: NavController) :
    EmaNavigator<HomeNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState {
        object FromHomeToChampion : Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                (navigator as HomeNavigator).fromHomeToChampion()
            }

        }
    }

    private fun fromHomeToChampion() {
        navigateWithAction((R.id.action_homeFragment_to_championFragment))
    }
}
