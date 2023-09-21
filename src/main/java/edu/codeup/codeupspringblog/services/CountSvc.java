package edu.codeup.codeupspringblog.services;

import edu.codeup.codeupspringblog.repositories.AdRepository;
import edu.codeup.codeupspringblog.repositories.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class CountSvc {

	private ContactRepository contactsDao;
	private AdRepository adsDao;

	public CountSvc(ContactRepository contactsDao, AdRepository adsDao) {
		this.contactsDao = contactsDao;
		this.adsDao = adsDao;
	}

	public long returnAdsContactsCount() {
		return contactsDao.count() + adsDao.count();
	}

}
