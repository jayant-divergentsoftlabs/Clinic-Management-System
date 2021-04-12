package com.divergentsl.clinicmanagementsystem;

import java.sql.Connection;


import java.sql.SQLException;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.divergentsl.clinicmanagementsystem.dao.PrescriptionDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.DatabaseManager;

public class Prescription {
	static final Logger myLogger = Logger
			.getLogger("Clinic-Management-Systemm/src/main/java/com/divergentsl/clinicmanagementsystem/Prescription.java");

	public static void prescription() {
		myLogger.setLevel(Level.FINE);
		Scanner sc = new Scanner(System.in);

		Connection con;
		

			System.out.println("Enter Drug Name");
			String name = sc.nextLine();
			System.out.println("Enter Drug MG");
			int mg = sc.nextInt();
			System.out.println("Enter Drug Quantity");
			int quantity = sc.nextInt();
			System.out.println("Enter Drug Days");
			int days = sc.nextInt();
			System.out.println("Enter Lab test");
			String test = sc.next();
			System.out.println("Enter the Note");
			String notes=sc.next();
			PrescriptionDao prescription = new PrescriptionDao(new DatabaseManager());
			try {
				prescription.create(name, mg,quantity,days,test,notes);
				myLogger.info("\n-------Insertion is Successful-------");
			} catch (SQLException e) {
				System.err.println(e);
				myLogger.info("\n--------Unsuccesful ----------");
			}
			

	}
}
/*
 * public static void historyAndPrescription() { try {
 * Class.forName("com.mysql.cj.jdbc.Driver"); Connection con =
 * DriverManager.getConnection(
 * "jdbc:mysql://localhost:3306/clinic-management-system", "root", "root");
 * Statement st = con.createStatement(); String sql =
 * "select patient.p_id,patient.p_name,patient.p_age,patient.p_gender,appointment.appointment_id,appoinment.patient_name,\r\n"
 * + "appointment.Dr_id,appointment.Problem,appointment.appointment_date\r\n" +
 * "prescription.drug_name,prescription.notes\r\n" +
 * "from patient inner join appointment on patient.p_id =  appointment.p_id   \r\n"
 * + "inner join prescription on patient.p_id = prescription.p_id\r\n" +
 * "order by appointment.appointment_date desc;"; ResultSet rs =
 * st.executeQuery(sql); if (!rs.next()) {
 * System.out.println("No record Found!\n"); DoctorLogin.doctorMethod(); } else
 * { System.out.
 * println("\n*-*-*-*-*-*-*-*-*-* History Of Patient *-*-*-*-*-*-*-*-*-*-*-*-*"
 * ); System.out.println(
 * "\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*Patient Data*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n"
 * ); String pid = rs.getString(1); String pname = rs.getString(2); String
 * pgender = rs.getString(3); String page = rs.getString(4); String doctorId =
 * rs.getString(5); String doctorname = rs.getString(6); String appoinId =
 * rs.getString(7); String pproblem = rs.getString(8); String appoindate =
 * rs.getString(9); String prescri = rs.getString(10); String note =
 * rs.getString(11); System.out.
 * printf("%5s  %20s  %3s  %7s  %5s  %20s  %5s  %10s  %15s  %30s  %30s\n", pid,
 * pname, pgender, page, doctorId, doctorname, appoinId, pproblem, appoindate,
 * prescri, note); System.out.println(
 * "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n"
 * ); } st.close(); con.close();
 * 
 * } catch (Exception e) { e.printStackTrace(); } }
 * 
 * }
 */