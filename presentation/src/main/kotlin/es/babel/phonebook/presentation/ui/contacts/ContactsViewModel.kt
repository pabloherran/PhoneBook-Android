package es.babel.phonebook.presentation.ui.contacts

import es.babel.phonebook.domain.manager.PermissionManager
import es.babel.phonebook.domain.usecase.contacts.GetAllContactsUseCase
import es.babel.phonebook.presentation.base.BaseViewModel
import es.babel.phonebook.presentation.model.contacts.ContactPresentationModel


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
        checkCallPhonePermission()
    }

    private fun checkReadContactPermissionAndGetThem() {
        if (!permissionManager.isReadContactsPermissionGranted()) {
            permissionManager.requestReadContactsPermission { getContacts() }
        } else getContacts()
    }

    private fun checkCallPhonePermission(): Boolean {
        if (!permissionManager.isCallPhonePermissionGranted()) {
            permissionManager.requestCallPhonePermission { }
            return false
        } else return true
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

    fun onActionPhoneClick(contactPresentationModel: ContactPresentationModel) {
        if (checkCallPhonePermission()) {
            navigate(
                ContactsNavigator.Navigation.Call(
                    ContactsViewState(
                        phoneList = listOf(),
                        phoneNumber = contactPresentationModel.phoneNumber
                    )
                )
            )
        }

    }

}
