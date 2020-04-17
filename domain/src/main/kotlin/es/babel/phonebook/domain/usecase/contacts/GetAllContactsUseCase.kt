package es.babel.phonebook.domain.usecase.contacts

import es.babel.easymvvm.core.usecase.EmaUseCase
import es.babel.phonebook.domain.model.contacts.ContactModel
import es.babel.phonebook.domain.repository.ContentResolverRepository

class GetAllContactsUseCase(private val contentResolverRepository: ContentResolverRepository) :
    EmaUseCase<Unit, List<ContactModel>>() {

    override suspend fun useCaseFunction(input: Unit): List<ContactModel> =
        contentResolverRepository.getAllContacts()

}
