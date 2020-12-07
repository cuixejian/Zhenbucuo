package com.webtest.dataprovider;
/**
 * author:cuixuejian
 
 */
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class MysqlDataProvider {
	

	
	public  Object[][] getTestDataByMysql(String sql) {
		String url = "jdbc:mysql://127.0.0.1:3306/root";
		List<Object[]> records = new ArrayList<Object[]>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection(url, "root", "123456");
			if (!conn.isClosed()) {
				System.out.println("isClosed");
			}
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int cols = rsMetaData.getColumnCount();
			System.out.println(cols);
			while (rs.next()) {
				String fields[] = new String[cols];

				int col=0;
				for (int i = 0; i < cols; i++) {
					fields[col] = rs.getString(i+1);
					col++;
				}
				records.add(fields);
			
			}
			rs.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[][] results = new Object[records.size()][];
		for (int i = 0; i < records.size(); i++) {
			results[i] = records.get(i);
		}
		return results;
	}


}
