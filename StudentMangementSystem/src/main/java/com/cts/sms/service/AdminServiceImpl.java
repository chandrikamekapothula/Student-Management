package com.cts.sms.service;

import org.springframework.stereotype.Service;

import com.cts.sms.model.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Override
	public boolean autheticateAdmin(Admin admin) {
		if(admin.getEmail().equals("admin@gmail.com") && admin.getPassword().equals("admin"))
			return true;
		return false;
	}

}
