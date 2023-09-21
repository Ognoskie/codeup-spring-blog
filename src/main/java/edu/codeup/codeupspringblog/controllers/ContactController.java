package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Contact;
import edu.codeup.codeupspringblog.repositories.ContactRepository;
import edu.codeup.codeupspringblog.services.CountSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ContactController {

	// Constructor Dependency Injection
	private ContactRepository contactsDao;

	private CountSvc countSvc;

	public ContactController(ContactRepository contactsDao, CountSvc countSvc) {
		this.contactsDao = contactsDao;
		this.countSvc = countSvc;
	}

	@GetMapping("/contacts")
	@ResponseBody
	public List<Contact> returnContacts() {
		return contactsDao.findAllByName("Justin");
	}

//    @GetMapping("/contacts/view")
//    public String returnContactsView(Model model) {
//        model.addAttribute("contacts", contactsDao.findAll());
//        return "contacts/index";
//    }

	@GetMapping("/contacts/ads/count")
	@ResponseBody
	public long returnContactsAdsCount() {
		return countSvc.returnAdsContactsCount();
	}





}

