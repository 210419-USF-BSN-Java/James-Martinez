package com.revature.assignments.controlflow;

import java.util.Scanner;

public class assignment1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number");
		int i = Integer.parseInt(scan.nextLine());
		String num = printNumberInWord(i);
		System.out.println(num);
		
		System.out.println("Enter a String");
		String str = scan.nextLine();
		String test = reverse(str);
		System.out.println(test);
		
	}

public static String printNumberInWord(int n) {
	String numName = "hello";
	String ar[] = {"ZERO","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
	if(n >= 0 && n <=9) {
		
		numName = ar[n];
	}else {
		numName = "OTHER";
	}
	return numName;
}


public static String reverse(String string) {
	String s2[] = string.split("");
	int strLen = s2.length;
	String s3[] = new String[strLen];
	for (int i = 0; i < strLen; i++) {
		s3[i] = s2[strLen - i - 1];
	}

	String s4 = new String();
	for (int i = 0; i < strLen; i++) {
		s4 = s4 + s3[i];
	}
	return s4;
}
}

