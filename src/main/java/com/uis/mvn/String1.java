package com.uis.mvn;

import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import com.uis.exception.InValidInputException;

public class String1 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("enter the name");
		String name = kb.nextLine();
		System.out.println(is20Character(name));
		System.out.println(profanityCheck(name));
		kb.close();
	}

	public static String is20Character(String name) {
		if (name.trim().isEmpty()) {
			throw new InValidInputException("please enter proper input");
		}
		StringBuffer sb = new StringBuffer();
		if (name.length() == 20) {
			sb = sb.append(name);
		} else if (name.length() > 20) {
			String dupName = name;
			for (int i = 1; i <= (name.length() - 20); i++) {
				dupName = StringUtils.chop(dupName);
			}
			sb = sb.append(dupName);
		} else if (name.length() < 20) {
			for (int i = 1; i <= (20 - (name.length())); i++) {
				sb = sb.append("*");
			}
			sb = sb.append(name);
		}

		String s = sb.toString();
		return s;
	}

	public static String profanityCheck(String name) {
		if (name.trim().isEmpty()) {
			throw new InValidInputException("please enter proper input");
		}
		String[] profanity = { "idiot", "mad", "mental" };
		StringBuffer sb = new StringBuffer();
		String[] ss = new String[profanity.length];

		for (int i = 0; i < profanity.length; i++) {
			char[] c1 = profanity[i].toCharArray();
			for (int j = 0; j < c1.length; j++) {
				sb = sb.append("*");
			}
			ss[i] = sb.toString();
			sb = new StringBuffer();
		}

		for (int i = 0; i < profanity.length; i++) {
			name = StringUtils.replaceIgnoreCase(name, profanity[i], ss[i]);
		}

		return name;
	}
}
