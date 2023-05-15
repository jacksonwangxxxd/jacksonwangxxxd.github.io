import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;

public class Final {

	public static void main(String[] args) {
		String server = "jdbc:mysql://140.119.19.73:3315/";
		String database = "111306048"; // change to your own database
		String url = server + database + "?useSSL=false";
		String username = "111306048"; // change to your own username
		String password = "zka77"; // change to your own password
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("DB Connectd");
			SelectUserFrame frame = new SelectUserFrame(conn);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}