package application;

import java.util.Scanner;

import file.FileCsv;

public class Program {
	
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("Enter file path: ");
		String filePath = sc.nextLine();		
		FileCsv fscv = new FileCsv(filePath);
	}

}
