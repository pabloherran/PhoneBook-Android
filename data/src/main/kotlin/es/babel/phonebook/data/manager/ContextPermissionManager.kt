package es.babel.phonebook.data.manager

import android.Manifest
import android.content.pm.PackageManager
import androidx.fragment.app.Fragment
import es.babel.phonebook.domain.manager.PermissionManager

class ContextPermissionManager(private val fragment: Fragment) : PermissionManager {

    companion object {
        const val PERMISSIONS_REQUEST_READ_CONTACTS = 100
        const val PERMISSIONS_REQUEST_CALL_PHONE = 101
    }

    private lateinit var callback: () -> Unit

    /**
     * READ_CONTACTS Permission
     */

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

    /**
     * CALL_PHONE Permission
     */

    override fun isCallPhonePermissionGranted(): Boolean =
        fragment.context?.checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED


    override fun requestCallPhonePermission(callback: () -> Unit) {
        this.callback = callback
        fragment.requestPermissions(
            arrayOf(Manifest.permission.CALL_PHONE),
            PERMISSIONS_REQUEST_CALL_PHONE
        )
    }

    override fun handleCallPhonePermissionGranted() {
        callback.invoke()
    }
}
