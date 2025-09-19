package com.member.controller;

public abstract class ManageMember {
	
	abstract boolean createMember(String name, String phone);
	
	abstract boolean readMember(int num);
	
	abstract boolean updateMember(int num, String name, String phone);

	abstract boolean deleteMember(int num);
	
	abstract boolean fileMember();
	
	abstract void listMember();

}
