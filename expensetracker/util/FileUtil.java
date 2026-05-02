package com.expensetracker.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.expensetracker.model.Expense;

public class FileUtil {
       
	private static final String FILE_NAME="expenses.csv";
	
	public static List<Expense> readFromFile(){
		List<Expense> expenses=new ArrayList<>();
		
		try(FileReader fr=new FileReader(FILE_NAME);
				BufferedReader br = new BufferedReader(fr)){
			
			String line;
			while((line=br.readLine())!=null) {
				try {
					expenses.add(Expense.parseExpense(line));
				
				}catch(IllegalArgumentException e) {
					System.out.println("inavild line: "+line);
				}
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("File not found.Strating fresh.");
		}catch(IOException e) {
			System.out.println("error in file");
		}
		return expenses;
	}
	
	public static void writeToFile(List<Expense> expenses) {
		try(FileWriter fw=new FileWriter(FILE_NAME);
				BufferedWriter bw=new BufferedWriter(fw)){
			 for (Expense exp : expenses) {
	                bw.write(exp.toCSV());
	                bw.newLine();
	            }
		}catch(IOException e) {
			System.out.println("Error in writing the csv.");
		}
				
				
	}
	
}