package com.core.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReplaceVowelWithX {

	public static void main(String[] args) {
		
		String filePath = "text.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line;
			while((line = br.readLine()) != null) {
				String modifiedLine = replaceVowelsWithX(line);
				System.out.println(modifiedLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String replaceVowelsWithX(String line) {
		return line.replaceAll("[aeiouAEIOU]", "X");
	}

}
