package com.member.controller;

import java.util.ArrayList;
import java.util.List;

import com.member.domain.Member;

public abstract class ManageMember {
	
	abstract int createMember(int num, String name, String phone, String addr, String password, ArrayList<Member> members);
	
	abstract boolean readMember(int num, List<Member> members);
	
	abstract boolean updateMember(int editedNum, String editName, String editPhone, String editAddr, List<Member> members);

	abstract boolean deleteMember(int num, List<Member> members);
	
	abstract void listMember(List<Member> members);
	
	abstract boolean fileMember(List<Member> members);

}
