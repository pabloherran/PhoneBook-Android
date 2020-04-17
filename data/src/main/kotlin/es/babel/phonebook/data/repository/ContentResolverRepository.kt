package es.babel.phonebook.data.repository

import android.content.ContentResolver
import android.provider.ContactsContract
import es.babel.phonebook.domain.model.contacts.ContactModel
import es.babel.phonebook.domain.repository.ContentResolverRepository

class ContentResolverRepository(private val contentResolver: ContentResolver) :
    ContentResolverRepository {

    override fun getAllContacts(): List<ContactModel> {
        val contacts = mutableListOf<ContactModel>()

        val projection = arrayOf(
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.Contacts.PHOTO_URI
        )

        val phones = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            projection,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
        )

        phones?.let {
            if (phones.count > 0) {
                while (phones.moveToNext()) {
                    contacts.add(
                        ContactModel(
                            name = phones.getString(
                                phones.getColumnIndex(
                                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                                )
                            ),
                            phoneNumber = phones.getString(
                                phones.getColumnIndex(
                                    ContactsContract.CommonDataKinds.Phone.NUMBER
                                )
                            )
                        )
                    )
                }
            }

            phones.close()
        }

        return contacts
    }

}
