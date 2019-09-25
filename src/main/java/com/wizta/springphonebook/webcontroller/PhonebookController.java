package com.wizta.springphonebook.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wizta.springphonebook.model.Phonebook;
import com.wizta.springphonebook.repository.PhonebookRepository;

@Controller
@RequestMapping("/phonebook")
@Transactional(readOnly = false, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
public class PhonebookController {

	private PhonebookRepository phonebookRepository;

	@Autowired
	public PhonebookController(PhonebookRepository phonebookRepository) {
		this.phonebookRepository = phonebookRepository;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "phonebook/create";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String create(Phonebook phonebook) {
		phonebookRepository.add(phonebook);
		return "phonebook/created";
	}

}