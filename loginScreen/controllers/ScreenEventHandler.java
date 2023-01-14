package loginScreen.controllers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import loginScreen.DeleteAccountWindow;
import loginScreen.ForgotPasswordWindow;
import loginScreen.LoginView;
import loginScreen.SignUpMenu;
import main.Main;

public class ScreenEventHandler {
	
	public void deleteAccountEmailField(JTextField emailField, JPasswordField passwordField) {
		if (emailField.getText().equals("Email")) {
            emailField.setText("");
        }
        if (passwordField.getText().equals("")) {
            passwordField.setEchoChar((char) 0);
        	passwordField.setText("Password");
        }
	}
	
	public void deleteAccountFrameClick(JTextField emailField, JPasswordField passwordField) {
		if (emailField.getText().equals("")) {
            emailField.setText("Email");
        }
        if (passwordField.getText().equals("")) {
            passwordField.setEchoChar((char) 0);
        	passwordField.setText("Password");
        }
	}
	
	public void deleteAccountPasswordField(JTextField emailField, JPasswordField passwordField) {
		if (passwordField.getText().equals("Password")) {
            passwordField.setEchoChar('*');
        	passwordField.setText("");
        }
        if (emailField.getText().equals("")) {
        	emailField.setText("Email");
        }
	}
	
	public void deleteAccountSubmitClick(JTextField emailField, JPasswordField passwordField, String key, File userFile, JLabel deleteStatus, UserController usc, FileEncryptionHandler enc) throws IOException {
		enc.decryptFile(key, userFile, userFile);
    	String email = emailField.getText();
    	String password = passwordField.getText();
    	String[] user = usc.getUser("email", email);
    	if (user == null) {
    		deleteStatus.setForeground(new Color(255, 51, 51));
		    deleteStatus.setText("Account does not exist!");
    	} else if (email.equals("Email") || email.equals("") || password.equals("Password") || password.equals("") ||
    			!user[1].equals(password)) {
    		deleteStatus.setForeground(new Color(255, 51, 51));
    		deleteStatus.setText("Invalid email or password!");
        } else if (user[1].equals(password) && user[2].equals(email)) {
			usc.deleteUser(email);
			deleteStatus.setForeground(new Color(102, 255, 102));
		    deleteStatus.setText("Account deleted successfully!");
		}
    	enc.encryptFile(key, userFile, userFile);
	}
	
	public void forgotPasswordEmailField(JTextField emailField) {
		if (emailField.getText().equals("Email")) {
			emailField.setText("");
		}
	}
	
	public void forgotPasswordFrameClick(JTextField emailField) {
		if (emailField.getText().equals("")) {
            emailField.setText("Email");
        }
	}
	
	
	public void forgotPasswordSubmitClick(UserController usc, JTextField emailField, JLabel passwordStatus) {
		String email = emailField.getText();
        if (!usc.checkEmailValidity(email) || email.equals("Email") || email.equals("")) {
            passwordStatus.setText("Invalid email! Try again.");
        } else if (usc.checkEmailValidity(email)) {
            passwordStatus.setForeground(new Color(102, 255, 102));
            passwordStatus.setText("Email sent successfully!");
        }
	}
	
	public void signUpUsernameField(JTextField usernameField, JPasswordField passwordField, JTextField emailField) {
		if (usernameField.getText().equals("Username")) {
            usernameField.setText("");
        }
        if (passwordField.getText().equals("")) {
            passwordField.setEchoChar((char) 0);
        	passwordField.setText("Password");
        }
        if (emailField.getText().equals("")) {
            emailField.setText("Email");
        }
	}
	
	public void signUpPasswordField(JTextField usernameField, JPasswordField passwordField, JTextField emailField) {
		if (passwordField.getText().equals("Password")) {
            passwordField.setEchoChar('*');
        	passwordField.setText("");
        }
        if (usernameField.getText().equals("")) {
            usernameField.setText("Username");
        }
        if (emailField.getText().equals("")) {
            emailField.setText("Email");
        }
	}
	
	public void signUpEmailField(JTextField usernameField, JPasswordField passwordField, JTextField emailField) {
		if (emailField.getText().equals("Email")) {
            emailField.setText("");
        }
        if (usernameField.getText().equals("")) {
            usernameField.setText("Username");
        }
        if (passwordField.getText().equals("")) {
            passwordField.setEchoChar((char) 0);
        	passwordField.setText("Password");
        }
	}
	
	public void signUpFrameClick(JTextField usernameField, JPasswordField passwordField, JTextField emailField) {
		if (usernameField.getText().equals("")) {
            usernameField.setText("Username");
        }
        if (passwordField.getText().equals("")) {
            passwordField.setEchoChar((char) 0);
        	passwordField.setText("Password");
        }
        if (emailField.getText().equals("")) {
            emailField.setText("Email");
        }
	}
	
	public void signUpSubmitClick(JTextField usernameField, JTextField emailField, JPasswordField passwordField, String key, File userFile, JLabel registerStatus, UserController usc, FileEncryptionHandler enc) throws IOException {
		enc.decryptFile(key, userFile, userFile);
    	String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
              
        if (username.equals("") || password.equals("") || email.equals("") ||
            username.equals("Username") || password.equals("Password") || email.equals("Email")) {
        	registerStatus.setForeground(new Color(255, 51, 51));
        	registerStatus.setText("One or more credentials missing!");
        } else if (!usc.checkEmailValidity(email)) {
        	registerStatus.setForeground(new Color(255, 51, 51));
        	registerStatus.setText("Invalid email format!");
        } else if (!usc.checkUser("email", email) && !usc.checkUser("username", username)) {
        	usc.registerUser(username, password, email);
        	registerStatus.setForeground(new Color(102, 255, 102));
        	registerStatus.setText("User registered successfully!");
        } else if (usc.checkUser("email", email) || usc.checkUser("username", username)) {
        	registerStatus.setForeground(new Color(255, 51, 51));
        	registerStatus.setText("User already exists!");
        }
        enc.encryptFile(key, userFile, userFile);
	}
	
	public void loginViewCheckPassClick() {
		ForgotPasswordWindow forgotPassword = new ForgotPasswordWindow();
        forgotPassword.setVisible(true);
	}
	
	public void loginViewCheckPassEnter(JLabel passwordCheck) {
		passwordCheck.setText("<HTML><u>Forgot password?</u></HTML>");
        passwordCheck.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	public void loginViewCheckPassExit(JLabel passwordCheck) {
		passwordCheck.setText("Forgot password?");
	}
	
	public void loginViewDeleteAccEnter(JLabel deleteAccountCheck) {
		deleteAccountCheck.setText("<HTML><u>Delete account</u></HTML>");
        deleteAccountCheck.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	public void loginViewDeleteAccExit(JLabel deleteAccountCheck) {
		deleteAccountCheck.setText("Delete account");
	}
	
	public void loginViewExitButtonEnter(Component exitButton) {
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	public void loginViewSignUpClick() {
		SignUpMenu signUpPanel = new SignUpMenu();
        signUpPanel.setVisible(true);
	}
	
	public void loginViewDeleteAccClick() {
		DeleteAccountWindow deleteAccount = new DeleteAccountWindow();
        deleteAccount.setVisible(true);
	}
	
	public void loginViewInputScreenClick(JTextField usernameField, JPasswordField passwordField) {
		if (usernameField.getText().equals("")) {
            usernameField.setText("Username");
        }
        if (passwordField.getText().equals("")) {
            passwordField.setEchoChar((char) 0);
        	passwordField.setText("Password");
        }
	}
	
	public void loginViewFrameClick(JTextField usernameField, JPasswordField passwordField) {
		if (usernameField.getText().equals("")) {
            usernameField.setText("Username");
        }
        if (passwordField.getText().equals("")) {
            passwordField.setText("Password");
        }
	}
	
	public void loginViewPasswordFieldClick(JTextField usernameField, JPasswordField passwordField) {
		if (passwordField.getText().equals("Password")) {
            passwordField.setText("");
            passwordField.setEchoChar('*');
        }
        if (usernameField.getText().equals("")) {
            usernameField.setText("Username");
        }
	}
	
	public void loginViewUsernameFieldClick(JTextField usernameField, JPasswordField passwordField) {
		if (usernameField.getText().equals("Username")) {
            usernameField.setText("");
        }
        if (passwordField.getText().equals("")) {
        	passwordField.setText("Password");
        }
	}
	public void loginViewLoginClick(JTextField usernameField, JPasswordField passwordField, String key, File userFile, JLabel loginStatus, UserController usc, FileEncryptionHandler enc) throws IOException {
		enc.decryptFile(key, userFile, userFile);
    	String username = usernameField.getText();
    	String password = passwordField.getText();
    	String[] user = usc.getUser("username", username);
    	
    	if (user == null || !user[0].equals(username) || !user[1].equals(password)) {
    		loginStatus.setForeground(new Color(255, 51, 51));
        	loginStatus.setText("Invalid username or password!");
        }
    	else if (user[0].equals(username) && user[1].equals(password)) {
    		startMain(username, password);
    		LoginView.closeWindow();
    		loginStatus.setForeground(new Color(102, 255, 102));
            loginStatus.setText("Login successful! Launching the game...");	           
    	}    	
    	enc.encryptFile(key, userFile, userFile);
	}
	
	public void startMain(String username, String password) {
		Main main = new Main();
        main.startMainMenu(username, password);
	}

	
}
