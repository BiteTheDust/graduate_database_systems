import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

public class Project {
	private int pid;
	private LocalDate start_date;
	private LocalDate finish_date;
	private String sponsor;
	private float budget;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getFinish_date() {
		return finish_date;
	}

	public void setFinish_date(LocalDate finish_date) {
		this.finish_date = finish_date;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}

	public static void addproject() {

		System.out.println("Getting ready to add project\n\n\n\n");
		Project x = new Project();
		int y, m, d;

		Scanner k = new Scanner(System.in);

		System.out.println("Enter the project id: ");
		x.setPid(k.nextInt());

		System.out.println("Enter the budget: ");
		x.setBudget(k.nextFloat());
		k.nextLine();

		System.out.println("Enter the Sponsor: "); // 10 characters or less as constructed by sql
		x.setSponsor(k.nextLine());

		System.out.println("Enter the Year it Started: ");
		y = k.nextInt();

		System.out.println("Enter the Month it Started, 1 for January, 2 for February, etc...: ");
		m = k.nextInt();

		System.out.println("Enter the Day it Started: ");
		d = k.nextInt();

		x.setStart_date(LocalDate.of(y, m, d));

		System.out.println("Now enter the end date starting with Year, Month, and Day");
		System.out.println("Year: ");
		y = k.nextInt();

		System.out.println("Month, 1 for January, 2 for February, etc...: ");
		m = k.nextInt();

		System.out.println("Day: ");
		d = k.nextInt();

		x.setFinish_date(LocalDate.of(y, m, d));

		/* insert code to send to db */

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s08",
					"cs4222s08", "alanalan");
			PreparedStatement stmt = con
					.prepareStatement("insert into Project(pid, sponsor, start_date, end_date, budget) values ('"
							+ x.getPid() + "', '" + x.getSponsor() + "', '" + x.getStart_date() + "', '"
							+ x.getFinish_date() + "', '" + x.getBudget() + "')");
			ResultSet Rs = stmt.executeQuery();
			con.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage() + " exception");
		}

		return;
	}

	public static void removeProject() {
		int remover;

		System.out.println("Enter the Project ID of the project you wish to remove");
		Scanner k = new Scanner(System.in);
		remover = k.nextInt();

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s08",
					"cs4222s08", "alanalan");
			PreparedStatement stmt = con.prepareStatement("DELETE FROM project WHERE pid = ?");

			stmt.setInt(1, remover);
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
