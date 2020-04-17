package es.babel.phonebook.presentation.ui.contacts

import androidx.navigation.NavController
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

class ContactsNavigator(override val navController: NavController) :
    EmaNavigator<ContactsNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState {
        //Nothing to do
    }
}
