package com.excelDb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public abstract class Generator {

	public static Connection connection()
			throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Properties properties = new Properties();
		properties.load(new FileInputStream("src//com//excelDb//application.properties"));
		return DriverManager.getConnection(properties.getProperty("jdbc.url"), properties);
	}

	public static void excelToDb(Connection connection) throws SQLException, FileNotFoundException, IOException {
		PreparedStatement prpStmt = connection.prepareStatement(
				"INSERT INTO `employeedetails`.`table1` (`Id`, `Name`,`Email`,`Salary`) VALUES (?,?,?,?)");
		int executeUpdate = 0;

		Workbook wb = new HSSFWorkbook(new FileInputStream("Employee.xls"));
		Sheet sheet = wb.getSheetAt(0);

		for (Row row : sheet) {
			System.out.println("entered");
			prpStmt.setInt(1, (int) row.getCell(0).getNumericCellValue());
			prpStmt.setString(2, row.getCell(1).getStringCellValue());
			prpStmt.setString(3, row.getCell(2).getStringCellValue());
			prpStmt.setLong(4, (int) row.getCell(3).getNumericCellValue());
			executeUpdate += prpStmt.executeUpdate();
		}
		
		wb.close();
	}

	public static void dbToExcel(Connection connection) throws SQLException, FileNotFoundException, IOException {
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("Student Result");
		Row row = null;

		int i = 0;
		Statement createStatement = connection.createStatement();
		ResultSet resultSet = createStatement.executeQuery("SELECT * FROM employeedetails.table2");

		while (resultSet.next()) {
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(resultSet.getInt(1));
			row.createCell(1).setCellValue(resultSet.getString(2));
			row.createCell(2).setCellValue(resultSet.getString(3));
			i++;
		}

		wb.write(new FileOutputStream("DbToExcel.xls"));
		wb.close();
	}
}
