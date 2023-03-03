package com.uis.mvn;

import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import com.uis.exception.InValidInputException;
public class String1 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("enter the name");
		String name = kb.nextLine();
		is20Character(name);
		kb.close();
	}

	public static void is20Character(String name) {
		if (name.trim().isEmpty() ) {
			throw new InValidInputException("please enter proper input");
		}
		
		if (name.length() == 20) {
			System.out.println(name);
		} else if (name.length() > 20) {
			String dupName = name;
			for (int i = 1; i <= (name.length() - 20); i++) {
				dupName = StringUtils.chop(dupName);
			}
			System.out.println(dupName);
		} else if (name.length() < 20) {
			for (int i = 1; i <= (20 - (name.length())); i++) {
				System.out.print("*");
			}
			System.out.println(name);
		}
	}

}
