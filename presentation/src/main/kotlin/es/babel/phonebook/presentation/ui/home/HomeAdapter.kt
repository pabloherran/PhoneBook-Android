package es.babel.phonebook.presentation.ui.home

import android.view.View
import es.babel.easymvvm.android.ui.EmaRecyclerAdapter
import es.babel.easymvvm.core.constants.STRING_EMPTY
import es.babel.phonebook.presentation.R
import kotlinx.android.synthetic.main.item_champion.view.*

class HomeAdapter(override val listItems: MutableList<ChampionItem>) : EmaRecyclerAdapter<HomeAdapter.ChampionItem>() {

    override val layoutItemId : Int = R.layout.item_champion

    override fun View.bind(item: ChampionItem, viewType: Int) {
        tvName.text = item.name
    }

    data class ChampionItem(
        val name: String,
        val firstAbility: String =STRING_EMPTY,
        val secondAbility: String =STRING_EMPTY,
        val thirdAbility: String = STRING_EMPTY,
        val fourthAbility: String = STRING_EMPTY
    )
}