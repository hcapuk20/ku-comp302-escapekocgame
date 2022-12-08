package loginScreen.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UserController {
	
	private String filepath = "loginScreen/controllers/users.txt";
	private String current;
	private String tempFile;

	public void registerUser(String username, String password, String email) throws IOException {
		FileWriter fw = new FileWriter(filepath, true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    
	    bw.write(String.format("%s,%s,%s", username, password, email));
	    bw.newLine();
	    bw.close();
	}
	
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
	
	public boolean checkUser(String field, String password) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String user;
		try {
		    while ((user = br.readLine()) != null) {
		       String[] spl = user.split(",");
		       if ((field.equals("username") && spl[0].equals(password)) ||
		    	   (field.equals("password") && spl[1].equals(password)) ||
		    	   (field.equals("email") && spl[2].equals(password))) {
		    	   return true;
		       }
		    }
		} finally {
		    br.close();
		}
		return false;
	}	
}
