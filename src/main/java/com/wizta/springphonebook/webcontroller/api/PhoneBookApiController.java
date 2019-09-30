package com.wizta.springphonebook.webcontroller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wizta.springphonebook.model.Phonebook;
import com.wizta.springphonebook.repository.PhonebookRepository;

@RestController
@RequestMapping("/api/phonebooks")
@Transactional(readOnly = false, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
public class PhoneBookApiController {

	private PhonebookRepository phonebookRepository;

	@Autowired
	public PhoneBookApiController(PhonebookRepository phonebookRepository) {
		this.phonebookRepository= phonebookRepository;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public int addPhonebook(@RequestBody Phonebook phonebook) {
		phonebookRepository.add(phonebook);
		return phonebook.getpersonID();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Phonebook> getAllPhonebooks() {
		return phonebookRepository.getAll();
	}

	@RequestMapping(value = "/{PersonID}", method = RequestMethod.GET)
	public Phonebook getPhonebook(@PathVariable int personID) {
		return phonebookRepository.get(personID);
	}

	@RequestMapping(value = "/{PersonID}", method = RequestMethod.PUT)
	public void updatePhonebook(@PathVariable int personID, @RequestBody Phonebook phonebookRequest) {
		Phonebook phonebook = phonebookRepository.get(personID);
		phonebook.setFirstName(phonebookRequest.getFirstName());
		phonebook.setLastName(phonebookRequest.getLastName());
		phonebook.setPhonenumber(phonebookRequest.getPhonenumber());
	}

	@RequestMapping(value = "/{PersonID}", method = RequestMethod.DELETE)
	public void removePhonebook(@PathVariable int personID) {
		Phonebook phonebook = phonebookRepository.get(personID);
		phonebookRepository.remove(phonebook);
	}
}
