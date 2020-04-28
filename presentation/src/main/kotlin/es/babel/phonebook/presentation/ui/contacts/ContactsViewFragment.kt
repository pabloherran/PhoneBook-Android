package es.babel.phonebook.presentation.ui.contacts

import android.content.pm.PackageManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.phonebook.data.manager.ContextPermissionManager
import es.babel.phonebook.domain.manager.PermissionManager
import es.babel.phonebook.presentation.R
import es.babel.phonebook.presentation.base.BaseFragment
import es.babel.phonebook.presentation.model.toPresentationModel
import kotlinx.android.synthetic.main.fragment_contacts.*
import org.kodein.di.generic.instance

class ContactsViewFragment :
    BaseFragment<ContactsViewState, ContactsViewModel, ContactsNavigator.Navigation>() {

    override val layoutId: Int = R.layout.fragment_contacts

    override val navigator: ContactsNavigator by instance<ContactsNavigator>()

    override val viewModelSeed: ContactsViewModel by instance<ContactsViewModel>()

    private lateinit var viewModel: ContactsViewModel

    private val permissionManager: PermissionManager by instance<PermissionManager>()

    override fun onInitialized(viewModel: ContactsViewModel) {
        this.viewModel = viewModel
        this.viewModel.permissionManager = permissionManager

        setUpRecycler()
    }

    override fun onSingleEvent(data: EmaExtraData) {
        //Nothing to do
    }

    override fun onStateAlternative(data: EmaExtraData) {
        //Nothing to do
    }

    override fun onStateError(error: Throwable) {
        //Nothing to do
    }

    override fun onStateNormal(data: ContactsViewState) {
        (rvContactList.adapter as? ContactsAdapter)?.updateList(
            data.phoneList.map { contactModel -> contactModel.toPresentationModel() }
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == ContextPermissionManager.PERMISSIONS_REQUEST_READ_CONTACTS &&
            grantResults.firstOrNull() == PackageManager.PERMISSION_GRANTED
        ) {
            permissionManager.handleReadContactsPermissionGranted()
        }

        if (requestCode == ContextPermissionManager.PERMISSIONS_REQUEST_CALL_PHONE &&
            grantResults.firstOrNull() == PackageManager.PERMISSION_GRANTED
        ) {
            permissionManager.handleCallPhonePermissionGranted()
        }

    }

    private fun setUpRecycler() {
        rvContactList.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        rvContactList.adapter =
            ContactsAdapter(mutableListOf(), itemListener = { viewModel.onActionPhoneClick(it) })


    }

}
