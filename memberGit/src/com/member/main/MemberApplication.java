package com.member.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.member.controller.ManageMemberControl;
import com.member.domain.Member;
import com.member.exception.*;

public class MemberApplication {
	public static void createAdmin(ArrayList<Member> members, int num) { // 관리자 생성 메서드 static 으로 선언
		members.add(new Member(num, "admin", "01011112222", "관리자주소", "admin"));
	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		ArrayList<Member> members = new ArrayList<>(); // 회원 리스트 생성
		ManageMemberControl controlMember = new ManageMemberControl();
		
		createAdmin(members, 0); // 회원 리스트 0번에 관리자 생성
		
		boolean quit = false; // while 탈출 조건, Menu 7. 종료에서 사용
		boolean logIn = false;
		int failCount = 0; 
		int num = 1;
		
		while(!quit) {
			if (!logIn) {
				if (failCount == 3) { // 비밀번호 3회 실패 시, 종료
					System.out.println("로그인횟수 초과");
					break;
				}
				
				System.out.println("*".repeat(30));
				System.out.println("로그인");
				System.out.println("*".repeat(30));
				
				System.out.print("아이디를 입력하세요: ");
				String inputAdminId = s.nextLine();			
				if (!inputAdminId.equals(members.get(0).getName())) { // 리스트 0번 Name 과 input 값 비교
					System.out.println("일치하는 아이디가 없습니다.");
					continue;
				}
				
				System.out.print("비밀번호를 입력하세요: ");
				String inputAdminPassword = s.nextLine();
				if (!inputAdminPassword.equals(members.get(0).getPassword())) { // password 비교
					System.out.println("비밀번호가 틀렸습니다.");
					failCount++;
					continue;
				}
				
				logIn = true;
				System.out.println("로그인 성공");
				
			}
			System.out.println();
			System.out.println("*".repeat(30));
			System.out.println("회원 관리 프로그램");
			System.out.println("*".repeat(30));
			System.out.println("1. 고객 정보 등록하기");
			System.out.println("2. 고객 정보 조회하기");
			System.out.println("3. 고객 정보 수정하기");
			System.out.println("4. 고객 정보 삭제하기");
			System.out.println("5. 고객 정보 목록보기");
			System.out.println("6. 고객 정보 파일출력");
			System.out.println("7. 종료");
			System.out.println("*".repeat(30));
			System.out.printf("testcode 현재 회원리스트 사이즈 : %02d \n",members.size()); // ##########test code##########
			System.out.print("메뉴 번호를 선택해주세요 ");
			
			int inputNum = s.nextInt();
			s.nextLine();
			
			Menu : switch (inputNum) {
			case 1:
				System.out.print("등록하실 회원의 이름을 입력하세요: ");
				String inputName = s.nextLine();
				
				for (int i = 1; i < members.size(); i++ ) {
					if (inputName.equals(members.get(i).getName())) {
						throw new DuplicateMemberException("이미 존재하는 이름입니다.");
					}
				}
				
				System.out.print("등록하실 회원의 연락처를 입력하세요: ");
				String inputPhone = s.nextLine();
				System.out.print("등록하실 회원의 주소를 입력하세요: ");
				String inputAddr = s.nextLine();
				System.out.print("등록하실 회원의 비밀번호를 입력하세요: ");
				String inputPassword = s.nextLine();
				num = controlMember.createMember(num, inputName, inputPhone, inputAddr, inputPassword, members);
				break;
			case 2:
				System.out.print("조회할 회원 이름을 입력해주세요 ");
				String searchName = s.nextLine();
				for (int i = 1; i < members.size(); i++) {
					if (searchName.equals(members.get(i).getName())) {
						controlMember.readMember(i, members);
						break Menu;
					}
				}
				throw new MemberNotFoundException("일치하는 회원이 없습니다.");
			case 3:
				System.out.print("수정할 회원 이름을 입력해주세요");
				String editedName = s.nextLine();
				int editedNum = -1;
				boolean isExist = false;
				for (int i = 1; i < members.size(); i++) {
					if (editedName.equals(members.get(i).getName())) {
						editedNum = i;
						isExist = true;
						break;
					}
				}
				if (!isExist) {
					throw new MemberNotFoundException("일치하는 회원이 없습니다.");
//						break Menu;						
				}
				System.out.printf("%s 회원의 이름을 수정하세요", editedName);
				String editName = s.nextLine();
				if (editName.trim() == "") {
					editName = members.get(editedNum).getName();
				}
				System.out.printf("%s 회원의 연락처를 수정하세요", editedName);
				String editPhone = s.nextLine();
				if (editPhone.trim() == "") {
					editPhone = members.get(editedNum).getPhone();
				}
				System.out.printf("%s 회원의 주소를 수정하세요", editedName);
				String editAddr = s.nextLine();
				if (editAddr.trim() == "") {
					editAddr = members.get(editedNum).getAddr();
				}
				System.out.printf("%s 회원의 비밀번호를 입력하세요", editedName);
				String editPassword = s.nextLine();
				if (editPassword.equals(members.get(editedNum).getPassword())) {
					controlMember.updateMember(editedNum, editName, editPhone, editAddr, members);
					break Menu;
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
					break Menu;
				}
			case 4:
				System.out.print("삭제할 회원 이름을 입력해주세요 ");
				String deleteName = s.nextLine();
				for (int i  = 1; i < members.size(); i++) {
					if (deleteName.equals(members.get(i).getName())) {
						System.out.print("비밀번호를 입력하세요: ");
						String deletePassword = s.nextLine();
						if (deletePassword.equals(members.get(i).getPassword())) {
							controlMember.deleteMember(i, members);
							break Menu;
						} else {
							System.out.println("비밀번호가 일치하지 않습니다.");
							break Menu;
						}
					}
					if (i == members.size() - 1) {
						throw new MemberNotFoundException("일치하는 회원이 없습니다.");
//						break Menu;
					}
				}
				break;
			case 5:
				controlMember.listMember(members);
				break;
			case 6: 
				controlMember.fileMember(members);
				break;
			case 7:
				quit = true;
				System.out.println("회원 관리 프로그램을 종료합니다.");
				break;
			default:
				System.out.println("올바른 숫자를 입력해주세요.");
			}
		}
		
	}

}
