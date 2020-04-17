package es.babel.phonebook.domain.repository

import es.babel.phonebook.domain.model.contacts.ContactModel

interface ContentResolverRepository {

    fun getAllContacts(): List<ContactModel>

}
