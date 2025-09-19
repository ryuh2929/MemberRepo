package com.member.controller;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.member.domain.Member;

public class ManageMemberControl extends ManageMember {

	@Override
	public int createMember(int num, String name, String phone, String addr, String password, ArrayList<Member> members) {
		members.add(new Member(num, name, phone, addr, password));
		num++; // 등록 후 회원 번호 1 증가
		System.out.println("등록 완료되었습니다.");
		return num;
	}

	@Override
	public boolean readMember(int i, List<Member> members) {
		System.out.printf("%s 고객 정보 : \n", members.get(i).getName());
		System.out.printf("회원번호: %02d \n", members.get(i).getNum());
		System.out.printf("이름: %s \n", members.get(i).getName());
		System.out.printf("연락처: %s \n", members.get(i).getPhone());
		System.out.printf("주소: %s \n", members.get(i).getAddr());
		return false;
	}

	@Override
	public boolean updateMember(int editedNum, String editName, String editPhone, String editAddr, List<Member> members) {
		members.get(editedNum).setName(editName);
		members.get(editedNum).setPhone(editPhone);
		members.get(editedNum).setAddr(editAddr);
		System.out.println("수정 완료되었습니다.");
		return false;
	}

	@Override
	public boolean deleteMember(int i, List<Member> members) {
		members.remove(members.get(i));
		System.out.println("삭제되었습니다.");
		return false;
	}

	@Override
	public void listMember(List<Member> members) {
		for (int i = 1; i < members.size(); i++) {
			System.out.printf("회원번호 %d  이름 %s  연락처 %s \n", i, members.get(i).getName(), members.get(i).getPhone());
		}		
	}

	@Override
	public boolean fileMember(List<Member> members) {
		try {
			File memberList = new File("memberList.txt");
			if (!memberList.exists()) {
				memberList.createNewFile();
			}
			FileWriter memberWriter = new FileWriter(memberList);
			
			for (int i = 1; i < members.size(); i++) {
				memberWriter.write(String.format("회원번호 : %d  이름 : %s  연락처 : %s  주소 : %s \n", i, members.get(i).getName(), members.get(i).getPhone(), members.get(i).getAddr()));
			}
			memberWriter.close();
			System.out.println("파일출력 완료");
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}
	
}
