package es.babel.phonebook.domain.manager

interface PermissionManager {

    fun isReadContactsPermissionGranted(): Boolean

    fun requestReadContactsPermission(callback: () -> Unit)

    fun handleReadContactsPermissionGranted()

    fun isCallPhonePermissionGranted(): Boolean

    fun requestCallPhonePermission(callback: () -> Unit)

    fun handleCallPhonePermissionGranted()

}
