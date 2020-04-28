package es.babel.phonebook.presentation.ui.contacts

import android.view.View
import es.babel.easymvvm.android.ui.EmaRecyclerAdapter
import es.babel.phonebook.presentation.R
import es.babel.phonebook.presentation.model.contacts.ContactPresentationModel
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactsAdapter(
    override val listItems: MutableList<ContactPresentationModel>,
    private val itemListener: (ContactPresentationModel) -> Unit
) : EmaRecyclerAdapter<ContactPresentationModel>() {

    override val layoutItemId: Int? = R.layout.item_contact

    override fun View.bind(item: ContactPresentationModel, viewType: Int) {
        tvItemContactName.text = item.name
        tvItemContactNumber.text = item.phoneNumber

        rootView.setOnClickListener {
            itemListener.invoke(item)
        }
    }

}
