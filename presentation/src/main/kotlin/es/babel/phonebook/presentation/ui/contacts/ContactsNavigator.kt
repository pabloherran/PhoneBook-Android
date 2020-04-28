package es.babel.phonebook.presentation.ui.contacts

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.pm.PackageManager
import android.net.Uri
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

class ContactsNavigator(override val navController: NavController, private val activity: Activity) :
    EmaNavigator<ContactsNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState {
        class Call(private val contactsViewState: ContactsViewState) : Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as ContactsNavigator
                nav.toCall(contactsViewState)
            }
        }
    }

    private fun toCall(contactsViewState: ContactsViewState) {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:" + contactsViewState.phoneNumber)
        callIntent.addFlags(FLAG_ACTIVITY_NEW_TASK)

        activity.applicationContext.startActivity(callIntent)
    }
}
