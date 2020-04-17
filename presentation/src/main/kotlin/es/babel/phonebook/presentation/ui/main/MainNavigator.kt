package es.babel.phonebook.presentation.ui.main

import androidx.navigation.NavController
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

class MainNavigator(override val navController: NavController) :
    EmaNavigator<MainNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState {
        //Nothing to do
    }

}
