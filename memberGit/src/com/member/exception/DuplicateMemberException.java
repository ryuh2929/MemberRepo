package com.member.exception;

public class DuplicateMemberException extends RuntimeException {
	public DuplicateMemberException(String message) {
		super(message);
	}

}
