package es.babel.phonebook.data.manager

import android.Manifest
import android.content.pm.PackageManager
import androidx.fragment.app.Fragment
import es.babel.phonebook.domain.manager.PermissionManager

class ContextPermissionManager(private val fragment: Fragment) : PermissionManager {

    private lateinit var callback: () -> Unit

    override fun isReadContactsPermissionGranted(): Boolean =
        fragment.context?.checkSelfPermission(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED

    override fun requestReadContactsPermission(callback: () -> Unit) {
        this.callback = callback
        fragment.requestPermissions(
            arrayOf(Manifest.permission.READ_CONTACTS),
            PERMISSIONS_REQUEST_READ_CONTACTS
        )
    }

    override fun handleReadContactsPermissionGranted() {
        callback.invoke()
    }

    companion object {
        const val PERMISSIONS_REQUEST_READ_CONTACTS = 100
    }

}
