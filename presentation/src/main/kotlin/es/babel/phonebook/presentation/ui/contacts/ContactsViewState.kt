package es.babel.phonebook.presentation.ui.contacts

import es.babel.easymvvm.core.constants.STRING_EMPTY
import es.babel.easymvvm.core.state.EmaBaseState
import es.babel.phonebook.domain.model.contacts.ContactModel

data class ContactsViewState(
    val phoneList: List<ContactModel>,
    val phoneNumber: String = STRING_EMPTY
) : EmaBaseState {
}