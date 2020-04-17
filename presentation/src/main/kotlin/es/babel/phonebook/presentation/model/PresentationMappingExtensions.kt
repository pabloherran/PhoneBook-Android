package es.babel.phonebook.presentation.model

import es.babel.phonebook.domain.model.contacts.ContactModel
import es.babel.phonebook.presentation.model.contacts.ContactPresentationModel

fun ContactModel.toPresentationModel(): ContactPresentationModel =
    ContactPresentationModel(
        name = this.name,
        phoneNumber = this.phoneNumber
    )
