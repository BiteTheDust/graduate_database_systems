import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Professor {

	private String PSSS;
	private String Name;
	private int age;
	private char Gender;
	private int Rank;
	private String Specialty;

	public Professor(String PSSS, String Name, int age, char Gender, int Rank, String Specialty) {
		this.PSSS = PSSS;
		this.Name = Name;
		this.age = age;
		this.Gender = Gender;
		this.Rank = Rank;
		this.Specialty = Specialty;
	}

	public Professor() {
		// TODO Auto-generated constructor stub
	}

	public String getPSSS() {
		return PSSS;
	}

	public void setPSSS(String pSSS) {
		PSSS = pSSS;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return Gender;
	}

	public void setGender(char gender) {
		Gender = gender;
	}

	public int getRank() {
		return Rank;
	}

	public void setRank(int rank) {
		Rank = rank;
	}

	public String getSpecialty() {
		return Specialty;
	}

	public void setSpecialty(String specialty) {
		Specialty = specialty;
	}

	public static void addprofessors() {

		System.out.println("Getting ready to add professor...\n\n");

		Professor x = new Professor();

		Scanner k = new Scanner(System.in);

		System.out.print("Enter Social Security: ");
		x.setPSSS(k.nextLine());

		System.out.print("Enter Name: ");
		x.setName(k.nextLine());

		System.out.print("Enter age: ");
		x.setAge(k.nextInt());
		k.nextLine();

		System.out.print("Enter sex: ");
		x.setGender(k.next().charAt(0));

		System.out.print("Enter rank: ");
		x.setRank(k.nextInt());

		System.out.print("Enter specialty: ");
		x.setSpecialty(k.next());

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s08",
					"cs4222s08", "alanalan");
			PreparedStatement stmt = con
					.prepareStatement("insert into Professor(pssn, name, age, gender, rank, speciality) values ('"
							+ x.getPSSS() + "', '" + x.getName() + "', '" + x.getAge() + "', '" + x.getGender() + "', '"
							+ x.getRank() + "', '" + x.getSpecialty() + "')");
			stmt.executeQuery();
			con.close();
		} catch (Exception ex) {
			System.out.println("The insertion has been completed!");
			// System.out.println(ex.getMessage(); for testing the query return message
		}

		return;
	}

	public static void removeProfessor() {

		String remover = "";

		System.out.println("Enter the SSN of the Faculty member you wish to remove");
		Scanner k = new Scanner(System.in);
		remover = k.next();

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s08",
					"cs4222s08", "alanalan");
			PreparedStatement stmt = con.prepareStatement("DELETE FROM professor WHERE pssn = ?");
			stmt.setString(1, remover);
			stmt.executeUpdate();

			if (con != null) {
				con.close();
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage() + " exception");
		}
		return;
	}

}
