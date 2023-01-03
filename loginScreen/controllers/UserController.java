package loginScreen.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class UserController {
	
	// Variables for the user file update and email control
	private String filepath = "assets/users.txt";
	private String current;
	private String tempFile;
	private String pattern = "(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)";
	
	// Method that registers a user with given credentials and updates the file accordingly
	public void registerUser(String username, String password, String email) throws IOException {
		FileWriter fw = new FileWriter(filepath, true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    
	    bw.write(String.format("%s,%s,%s", username, password, email));
	    bw.newLine();
	    bw.close();
	}
	
	// Method that deletes user from the user file based on email address
	public void deleteUser(String email) {
		tempFile = "temp.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
			
		try {
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			FileReader fr = new FileReader(filepath);
			BufferedReader br = new BufferedReader(fr);
			while ((current = br.readLine()) != null) {
				String[] spl = current.split(",");
				if (!spl[2].equals(email)) {
					pw.println(current);
				}
			}
			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();
			
			oldFile.delete();
			File filename = new File(filepath);
			newFile.renameTo(filename);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// Method that checks if a user exists in the user file based on given credential
	public boolean checkUser(String field, String credential) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String user;
		try {
		    while ((user = br.readLine()) != null) {
		       String[] spl = user.split(",");
		       if ((field.equals("username") && spl[0].equals(credential)) ||
		    	   (field.equals("password") && spl[1].equals(credential)) ||
		    	   (field.equals("email") && spl[2].equals(credential))) {
		    	   return true;
		       } 
		    }
		} finally {
		    br.close();
		}
		return false;
	}	
	
	// Method that returns the user in array format based on given credential
	public String[] getUser(String field, String credential) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String user;
		try {
		    while ((user = br.readLine()) != null) {
		       String[] spl = user.split(",");
		       if ((field.equals("username") && spl[0].equals(credential)) ||
			       (field.equals("email") && spl[2].equals(credential))) {
			    	   return spl;
			       } 
		    }
		} finally {
			br.close();
		}
		return null;
	}
	
	// Method that checks if given email address is formatted correctly
	public boolean checkEmailValidity(String emailAddress) {
	    return Pattern.compile(pattern).matcher(emailAddress).matches();
	}
}
