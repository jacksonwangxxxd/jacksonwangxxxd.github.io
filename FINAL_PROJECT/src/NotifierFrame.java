						import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class NotifierFrame extends JFrame {

	private User user = new User();
	private JTextField web;
	private JTextArea area;
	private JButton btnBack, btnAdd;
	private JLabel label = new JLabel();
	private JPanel panel = (JPanel) this.getContentPane();
	private JPanel errorPanel;
	private JScrollPane jScrollPane;
	Connection conn;
	Statement stat;

	public NotifierFrame(Connection conn) throws SQLException {
		this.conn = conn;
		stat = conn.createStatement();
		setTitle("通報者");
		setSize(600, 400);
		createTextField();
		createButton();
		panel = new JPanel();
		createLayout();
	}

	private void createLayout() {
		createTextField();
		JPanel uPanel = new JPanel();
		uPanel.add(new JLabel("欲通報網站連結:"));
		uPanel.add(web);
		uPanel.setPreferredSize(new Dimension(500, 40));
		JPanel pPanel = new JPanel();
		pPanel.add(new JLabel("網站問題簡述:"));
		pPanel.add(jScrollPane);
		pPanel.setPreferredSize(new Dimension(500, 40));
		JPanel bPanel = new JPanel();
		bPanel.add(btnBack);
		bPanel.add(btnAdd);
		bPanel.setPreferredSize(new Dimension(500, 40));
		JPanel panel = new JPanel();
		panel.add(label);
		JPanel allPannel = new JPanel();
		allPannel.add(uPanel);
		allPannel.add(pPanel);
		allPannel.add(bPanel);
		allPannel.add(panel);
		setLayout(new BorderLayout(20, 40));
		getContentPane().add(new JPanel(), BorderLayout.NORTH);
		getContentPane().add(allPannel, BorderLayout.CENTER);
		getContentPane().add(new JPanel(), BorderLayout.SOUTH);
	}

	public void createButton() {
		btnAdd = new JButton("新增");
		btnBack = new JButton("返回");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String query = "";
				String website = web.getText();
				String problem = area.getText();
				query = String.format("INSERT INTO `Website`(`Website`, `Problem`) VALUES ('%s','%s')", website,
						problem);
				try {
					stat.execute(query);
					label.setText("謝謝你的通報，下次別通報了");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				SelectUserFrame frame;
				
				try {
					frame = new SelectUserFrame(conn);
					frame.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public void createTextField() {
		web = new JTextField(8);
		area = new JTextArea(3, 30);
		this.area.setLineWrap(true);
		jScrollPane = new JScrollPane(area);
	}//your code
}
