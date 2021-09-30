package es.babel.phonebook.presentation.ui.champion

import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.phonebook.presentation.R
import es.babel.phonebook.presentation.base.BaseFragment
import org.kodein.di.generic.instance

class ChampionFragment : BaseFragment<ChampionState, ChampionViewModel, ChampionNavigator.Navigation>() {

    override val layoutId: Int = R.layout.fragment_champion

    override fun onInitialized(viewModel: ChampionViewModel) {

    }

    override val navigator: ChampionNavigator by instance()

    override val viewModelSeed: ChampionViewModel by instance()

    override fun onSingleEvent(data: EmaExtraData) {

    }

    override fun onStateAlternative(data: EmaExtraData) {

    }

    override fun onStateError(error: Throwable) {

    }

    override fun onStateNormal(data: ChampionState) {

    }
}