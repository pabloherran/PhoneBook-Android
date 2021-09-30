package es.babel.phonebook.presentation.ui.home

import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.phonebook.presentation.R
import es.babel.phonebook.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.kodein.di.generic.instance

class HomeFragment : BaseFragment<HomeState, HomeViewModel, HomeNavigator.Navigation>() {

    override val layoutId: Int = R.layout.fragment_home

    override fun onInitialized(viewModel: HomeViewModel) {
        rvHome.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        rvHome.adapter = HomeAdapter(mutableListOf())
    }

    override val navigator: HomeNavigator by instance()

    override val viewModelSeed: HomeViewModel by instance()

    override fun onSingleEvent(data: EmaExtraData) {

    }

    override fun onStateAlternative(data: EmaExtraData) {

    }

    override fun onStateError(error: Throwable) {

    }

    override fun onStateNormal(data: HomeState) {
        (rvHome.adapter as HomeAdapter).updateList(data.championList)
    }

}