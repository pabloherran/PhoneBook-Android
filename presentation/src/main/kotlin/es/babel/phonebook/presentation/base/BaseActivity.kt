package es.babel.phonebook.presentation.base

import es.babel.easymvvm.android.ui.EmaFragmentActivity
import es.babel.phonebook.presentation.di.generateActivityModule
import org.kodein.di.Kodein

abstract class BaseActivity : EmaFragmentActivity() {

    override fun injectActivityModule(kodein: Kodein.MainBuilder) =
        generateActivityModule(activity = this)

}
