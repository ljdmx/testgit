package com.ljd.account.util;

@SuppressWarnings("serial")
public class LessMoneyException extends Exception {
public LessMoneyException() {}
public String toString() {
	return "less money";
}
}
