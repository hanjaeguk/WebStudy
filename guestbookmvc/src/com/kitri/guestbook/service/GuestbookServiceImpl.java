package com.kitri.guestbook.service;

import java.util.List;

import com.kitri.guestbook.model.GuestbookDto;
import com.kitri.guestbook.model.dao.GuestbookDao;
import com.kitri.guestbook.model.dao.GuestbookDaoImpl;


public class GuestbookServiceImpl implements GuestbookService {

	private GuestbookDao guestbookDao;
	
	public GuestbookServiceImpl(){
		guestbookDao = new GuestbookDaoImpl();
	}
	
	@Override
	public int writeGuestbook(GuestbookDto guestbookDto) {
		return guestbookDao.writeGuestbook(guestbookDto);
	}

	@Override
	public List<GuestbookDto> guestbooklist() {
		return null;
	}

}
