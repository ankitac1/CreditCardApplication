package com.cg.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Admin;
import com.cg.repository.IAdminRepository;
import com.cg.service.IAdminService;

@Service
public class IAdminServiceImpl implements IAdminService {

	@Autowired
	IAdminRepository adminrepository;
	
	@Override
	public Admin addAdmin(Admin admin) {
		
		adminrepository.save(admin);
		return admin;		
		
	}

}
