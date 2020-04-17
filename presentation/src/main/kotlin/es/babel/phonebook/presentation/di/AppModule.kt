package es.babel.phonebook.presentation.di

import android.content.ContentResolver
import es.babel.phonebook.domain.usecase.contacts.GetAllContactsUseCase
import es.babel.phonebook.presentation.Application
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun generateAppModule(app: Application) = Kodein.Module(name = "AppModule") {

    bind<Application>() with singleton { app }

    bind<ContentResolver>() with singleton { app.contentResolver }

    bind<GetAllContactsUseCase>() with provider { GetAllContactsUseCase(instance()) }

}
