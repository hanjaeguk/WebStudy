package com.kitri.guestbook.service;

import java.util.List;

import com.kitri.guestbook.model.GuestbookDto;

public interface GuestbookService {
	int writeGuestbook(GuestbookDto guestbookDto);
	List<GuestbookDto>guestbooklist();
}
