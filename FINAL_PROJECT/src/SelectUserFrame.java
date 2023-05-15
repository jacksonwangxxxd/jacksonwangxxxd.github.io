import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SelectUserFrame extends JFrame {
	
	LoginFrame frame;
	private JButton goBtn;
	private JPanel userKindPanel, allPanel;
	public JComboBox userCombo;
	private JLabel label;
	Connection conn;
	Statement stat;


	
	public SelectUserFrame(Connection conn) throws SQLException {
		this.conn = conn;
		setTitle("資安神盾局");
		setSize(500,300);
		createUserCombo();
		createBtn();
		createLayout();
	}
	public void createUserCombo() {
		userCombo = new JComboBox();
		userCombo.addItem("通報者");
		userCombo.addItem("網站管理者");
		userCombo.addItem("系統管理者");

	}
	public void createLayout() {
		label = new JLabel();
		allPanel = new JPanel();
		userKindPanel = new JPanel();
		label.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		label.setText("政大校網內容置換通報系統");
		userKindPanel.add(userCombo);
		allPanel.add(label);
		allPanel.add(goBtn);
		allPanel.add(userKindPanel);
		allPanel.setPreferredSize(new Dimension(500, 100));
		this.setLayout(new BorderLayout(20, 60));
		this.getContentPane().add(allPanel, BorderLayout.CENTER);
	}
	public void createBtn() {
		goBtn = new JButton("Go");
		goBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(userCombo.getSelectedItem().equals("通報者")) {
					NotifierFrame frame;
					try {
						frame = new NotifierFrame(conn);
						
						frame.setVisible(true);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					frame = new LoginFrame();
					frame.setVisible(true);
				}
				
			}

		});
	}
}
