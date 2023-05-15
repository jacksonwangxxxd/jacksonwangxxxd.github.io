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
import javax.swing.JTextField;

public class SystemManagerFrame extends JFrame {
	
	private User user = new User();
	private JTextField tfUserName, tfPassword;
	private JButton btnEnroll, btnLogin;
	private JLabel label;
	private JComboBox userCombo;
	private JPanel panel = (JPanel) this.getContentPane();
	private JPanel errorPanel;

	
	public SystemManagerFrame() {
//your code
		label = new JLabel();
		label.setText("政大校網內容置換通報系統");
		setTitle("系統管理者");
		setSize(600,400);
		createTextField();
		createButton();
		panel = new JPanel();
		createLayout();
	}
	
	private void createLayout() {
		JPanel uPanel = new JPanel();
		uPanel.add(new JLabel("使用者名稱:"));
		uPanel.add(tfUserName);
		uPanel.setPreferredSize(new Dimension(500, 40));
		JPanel pPanel = new JPanel();
		pPanel.add(new JLabel("密碼:"));
		pPanel.add(tfPassword);
		pPanel.setPreferredSize(new Dimension(500, 40));
		JPanel bPanel = new JPanel();
		bPanel.add(userCombo);
		bPanel.add(btnEnroll);
		bPanel.add(btnLogin);
		bPanel.setPreferredSize(new Dimension(500, 40));
		JPanel allPannel = new JPanel();
		allPannel.add(uPanel);
		allPannel.add(pPanel);
		allPannel.add(bPanel);
		setLayout(new BorderLayout(20, 40));
		getContentPane().add(new JPanel(), BorderLayout.NORTH);
		getContentPane().add(allPannel, BorderLayout.CENTER);
		getContentPane().add(new JPanel(), BorderLayout.SOUTH);
	}
	public void createButton() {
		btnLogin = new JButton("登入");
		btnEnroll = new JButton("註冊");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					user.checkUserExist(tfUserName.getText());
					user.checkPassword(tfUserName.getText(), tfPassword.getText());
				} catch (UserError  e) {
					JOptionPane.showMessageDialog(errorPanel, "查無此使用者",
				               "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				} catch (PasswordError e) {
					JOptionPane.showMessageDialog(errorPanel, "密碼錯誤",
				               "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}

		});
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					user.add(tfUserName.getText(), tfPassword.getText(), (String)userCombo.getSelectedItem());
				} catch (PasswordError e) {
					JOptionPane.showMessageDialog(errorPanel, "密碼須為10個字",
				               "Error", JOptionPane.ERROR_MESSAGE);					
					e.printStackTrace();
				} catch (UserError e) {
					JOptionPane.showMessageDialog(errorPanel, "請填寫使用者名稱",
				               "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}

			}
		});
	}
	public void createTextField() {
		tfUserName = new JTextField(8);
		tfPassword = new JTextField(8);
	}
//your code
}

	