package es.babel.phonebook.presentation.ui.home

import es.babel.easymvvm.core.constants.STRING_EMPTY
import es.babel.easymvvm.core.state.EmaBaseState

data class HomeState(
    val variable: String = STRING_EMPTY,
    val changeMeButtonEnabled: Boolean = false,
    val championList: List<HomeAdapter.ChampionItem> = emptyList()
) : EmaBaseState