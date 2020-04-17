package es.babel.phonebook.presentation.base

import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.easymvvm.core.navigator.EmaNavigationState

abstract class BaseViewModel<S, NS : EmaNavigationState> : EmaViewModel<S, NS>()

