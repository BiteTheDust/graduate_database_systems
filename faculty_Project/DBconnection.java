import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import java.time.LocalDate;
import java.time.Month;

public class DBconnection {
	public static void main(String[] args) {

		String queries = "";
		char RemoveorAdd = ' ';

		while (!(queries.equals("quit"))) {
			Scanner k = new Scanner(System.in);

			System.out.println("--------------------------- Professors or Projects ---------------------------");
			System.out.println("Enter 'f' for Professors, 'p' for Projects, 'd' for display or enter 'quit' to quit:");

			queries = k.next();

			if (queries.equals("f")) {

				System.out.println("Removing or Adding");
				System.out.println("Enter 'r' to remove or 'a' to add a record");
				RemoveorAdd = k.next().charAt(0);
				if (RemoveorAdd == 'a' || RemoveorAdd == 'A') {
					Professor.addprofessors();
				} else {
					Professor.removeProfessor();
				}

			} else if (queries.equals("p")) {

				System.out.println("Removing or Adding");
				System.out.println("Enter 'r' to remove or 'a' to add a record\n");
				RemoveorAdd = k.next().charAt(0);
				if (RemoveorAdd == 'a' || RemoveorAdd == 'A') {
					Project.addproject();
				} else {
					Project.removeProject();
				}
			} else if (queries.equals("d")) {

				System.out.println("The University Database: ");
				displayAll();
			} else {
				continue;
			}
		}
	}

	public static void displayAll() {
		System.out.println("\n-----------------Professors-----------------\n|---SSN----|---Name------|-Age-|Sex|Rank|Specialty|");
		try {
			Class.forName("org.postgresql.Driver");
			Connection display = DriverManager.getConnection("jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s08",
					"cs4222s08", "alanalan");
			PreparedStatement prof = display.prepareStatement("select * from Professor");
			ResultSet p = prof.executeQuery();
			while (p.next()) {
				System.out.println(p.getString(1) + " | " + p.getString(2) + " | " + p.getInt(3) + " | "
						+ p.getString(4) + " | " + p.getInt(5) + " | " + p.getString(6));
			}
			display.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage() + " exception");
		}
		System.out.println("\n-----------------Students-----------------\n|---SSN----|---Name-------|-Age-|Sex|---Deg_Prog-----|Major|");
		// Student
		try {
			Class.forName("org.postgresql.Driver");
			Connection display = DriverManager.getConnection("jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s08",
					"cs4222s08", "alanalan");
			PreparedStatement prof = display.prepareStatement("select * from Student");
			ResultSet p = prof.executeQuery();
			while (p.next()) {
				System.out.println(p.getString(1) + " | " + p.getString(2) + " | " + p.getInt(3) + " | "
						+ p.getString(4) + " | " + p.getString(5) + " | " + p.getInt(6));
			}
			display.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage() + " exception");
		}
		System.out.println("\n-----------------Projects-----------------\n|PID|-Sponsor--|-Start Date-|-End Date---|---Budget---|");
		try {
			Class.forName("org.postgresql.Driver");
			Connection display = DriverManager.getConnection("jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s08",
					"cs4222s08", "alanalan");
			PreparedStatement prof = display.prepareStatement("select * from Project");
			ResultSet p = prof.executeQuery();
			while (p.next()) {
				System.out.println(p.getInt(1) + " | " + p.getString(2) + " | " + p.getString(3) + " | "
						+ p.getString(4) + " | " + p.getBigDecimal(5));
			}
			display.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage() + " exception");
		}
		System.out.println("\n----------Departments----------\n|DNO|-----DName-----|-Office-|");
		try {
			Class.forName("org.postgresql.Driver");
			Connection display = DriverManager.getConnection("jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s08",
					"cs4222s08", "alanalan");
			PreparedStatement prof = display.prepareStatement("select * from Dapartment");
			ResultSet p = prof.executeQuery();
			while (p.next()) {
				System.out.println(p.getInt(1) + " | " + p.getString(2) + " | " + p.getString(3));
			}
			display.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage() + " exception");
		}

	}
}
