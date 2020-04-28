package es.babel.phonebook.presentation.di

import androidx.navigation.NavController
import es.babel.phonebook.presentation.base.BaseActivity
import es.babel.phonebook.presentation.ui.contacts.ContactsNavigator
import es.babel.phonebook.presentation.ui.main.MainNavigator
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

fun generateActivityModule(activity: BaseActivity) = Kodein.Module(name = "ActivityModule") {

    bind<BaseActivity>() with singleton { activity }

    bind<NavController>() with singleton { activity.navController }

    bind<MainNavigator>() with singleton { MainNavigator(instance()) }

    bind<ContactsNavigator>() with singleton { ContactsNavigator(instance(), instance()) }

}
