package application;

import java.util.Scanner;

import exception.ProgramException;
import file.FileCsv;

public class Program {
	
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("Enter file path: ");
		String filePath = sc.nextLine();
		
		try {
			FileCsv fscv = new FileCsv(filePath);
			fscv.readAndWrite();	
		} catch (ProgramException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			sc.close();
		}
	}

}
