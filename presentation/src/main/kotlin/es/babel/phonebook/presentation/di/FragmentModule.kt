package es.babel.phonebook.presentation.di

import androidx.fragment.app.Fragment
import es.babel.phonebook.data.manager.ContextPermissionManager
import es.babel.phonebook.domain.manager.PermissionManager
import es.babel.phonebook.presentation.ui.contacts.ContactsViewModel
import es.babel.phonebook.presentation.ui.home.HomeViewModel
import es.babel.phonebook.presentation.ui.main.MainViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun generateFragmentModule(fragment: Fragment) = Kodein.Module(name = "FragmentModule") {

    bind<Fragment>() with provider { fragment }

    bind<MainViewModel>() with provider { MainViewModel() }

    bind<HomeViewModel>() with provider { HomeViewModel() }

    bind<ContactsViewModel>() with provider { ContactsViewModel(instance()) }

    bind<PermissionManager>() with singleton { ContextPermissionManager(instance()) }

}
