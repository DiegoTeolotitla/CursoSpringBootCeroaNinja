package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.component.ContactConverter;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.repository.ContactRepository;
import com.udemy.service.ContactService;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactServiceImpl.
 */
@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

	/** The contact repository. */
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;

	/** The contact converter. */
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	/**
	 * Adds the contact.
	 *
	 * @param contactModel the contact model
	 * @return the contact model
	 */
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convertContactModelToContact(contactModel));

		return contactConverter.convertContactToContactModel(contact);
	}

	/**
	 * List all contacts.
	 *
	 * @return the list
	 */
	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactModels = new ArrayList<>();
		for (Contact contact : contacts) {
			contactModels.add(contactConverter.convertContactToContactModel(contact));
		}

		return contactModels;
	}

	/**
	 * Find contact by id.
	 *
	 * @param id the id
	 * @return the contact
	 */
	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
	}

	/**
	 * Removes the contact.
	 *
	 * @param id the id
	 */
	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
		if (contact != null) {
			contactRepository.delete(contact);
		}
	}

	/**
	 * Find contact by id model.
	 *
	 * @param id the id
	 * @return the contact model
	 */
	@Override
	public ContactModel findContactByIdModel(int id) {
		return contactConverter.convertContactToContactModel(findContactById(id));
	}

}
