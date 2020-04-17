package es.babel.phonebook.presentation

import es.babel.easymvvm.android.base.EmaApplication
import es.babel.phonebook.data.di.generateDataModule
import es.babel.phonebook.presentation.di.generateAppModule
import org.kodein.di.Kodein

class Application : EmaApplication() {

    override val kodein: Kodein
        get() = super.kodein.apply { Kodein }

    override fun injectAppModule(kodein: Kodein.MainBuilder): Kodein.Module {
        kodein.import(generateDataModule())
        return generateAppModule(app = this)
    }

}
