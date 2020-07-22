package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import service.ValidateLogin;

public class Main {
	
	public static void main(String[] args) throws Exception {
	LocalDateTime obj = LocalDateTime.now();
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-mm-yyyy HH:MM:SS");
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("=================================");
	System.out.println("=============WELCOME=============");
	System.out.println("=================================");
	System.out.println("Enter your choice");
	System.out.println("1. LOGIN");
	System.out.println("2. EXIT");
	int x=Integer.parseInt(br.readLine());
	ValidateLogin val=new ValidateLogin();
	Manager man=new Manager();
	switch(x) {
		case 1: 
			System.out.println("Enter your username");
			String user=br.readLine();
			System.out.println("Enter your password");
			String password=br.readLine();
			if(val.validate(user, password)) {
				man.admin();
			}
			else {
				System.out.println("Check your username and password");
			}
			break;
			
		case 2:
			System.out.println("=================================");
			System.out.println("============THANK YOU============");
			System.out.println("=================================");
			break;
		}
	}
}
