package com.kitri.guestbook.model.dao;

import java.util.List;

import com.kitri.guestbook.model.GuestbookDto;

public interface GuestbookDao {
	
	int writeGuestbook(GuestbookDto guestbookDto);
	List<GuestbookDto>guestbooklist();
	
}
