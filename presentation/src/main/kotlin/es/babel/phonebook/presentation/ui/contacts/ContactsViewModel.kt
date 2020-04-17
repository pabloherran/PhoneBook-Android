package es.babel.phonebook.presentation.ui.contacts

import es.babel.phonebook.domain.manager.PermissionManager
import es.babel.phonebook.domain.usecase.contacts.GetAllContactsUseCase
import es.babel.phonebook.presentation.base.BaseViewModel

class ContactsViewModel(
    private val getAllContactsUseCase: GetAllContactsUseCase
) : BaseViewModel<ContactsViewState, ContactsNavigator.Navigation>() {

    lateinit var permissionManager: PermissionManager

    override val initialViewState: ContactsViewState = ContactsViewState(listOf())

    override fun onResume(firstTime: Boolean) {
        if (permissionManager.isReadContactsPermissionGranted()) getContacts()
    }

    override fun onStartFirstTime(statePreloaded: Boolean) {
        checkReadContactPermissionAndGetThem()
    }

    private fun checkReadContactPermissionAndGetThem() {
        if (!permissionManager.isReadContactsPermissionGranted()) {
            permissionManager.requestReadContactsPermission { getContacts() }
        } else getContacts()
    }

    private fun getContacts() {
        executeUseCase {
            val contacts = getAllContactsUseCase.execute(Unit)

            updateToNormalState {
                copy(
                    phoneList = contacts
                )
            }
        }
    }

}
