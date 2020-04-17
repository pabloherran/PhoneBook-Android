package es.babel.phonebook.data.di

import es.babel.phonebook.domain.repository.ContentResolverRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

fun generateDataModule() = Kodein.Module(name = "DataModule") {

    bind<ContentResolverRepository>() with singleton {
        es.babel.phonebook.data.repository.ContentResolverRepository(
            instance()
        )
    }

}
