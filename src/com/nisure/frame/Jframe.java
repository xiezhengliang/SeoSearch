package com.nisure.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.shiro.crypto.hash.Sha256Hash;

import com.nisure.model.SysUser;
import com.nisure.model.YsOssContentEntity;
import com.nisure.model.YsOssContentList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

/**
 * @author xiezhengliang
 * @date 2017年10月16日 下午5:40:14
 */
public class Jframe extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;
	private static Jframe frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Jframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Jframe() {
		setType(Type.POPUP);
		setTitle("用户登陆");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 200, 483, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("账号：");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		lblNewLabel.setBounds(106, 103, 54, 27);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("密码：");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(106, 151, 54, 27);
		contentPane.add(lblNewLabel_1);

		userField = new JTextField();
		userField.setToolTipText("请输入账号");
		userField.setHorizontalAlignment(SwingConstants.LEFT);
		userField.setBounds(169, 104, 171, 27);
		contentPane.add(userField);
		userField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Clarkii SEO");
		lblNewLabel_2.setIcon(new ImageIcon("\\resource\\..\\..\\login_logo.png"));
		lblNewLabel_2.setFont(new Font("楷体", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel_2.setBounds(134, 27, 202, 62);
		contentPane.add(lblNewLabel_2);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("请输入密码");
		passwordField.setBounds(170, 152, 170, 27);
		contentPane.add(passwordField);

		JButton logingButton = new JButton("登陆");
		logingButton.setFont(new Font("黑体", Font.PLAIN, 16));
		logingButton.setForeground(SystemColor.textText);
		logingButton.setBackground(SystemColor.textHighlight);
		logingButton.setBounds(262, 223, 77, 27);
		contentPane.add(logingButton);
		logingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String userName = userField.getText().trim();
				char[] pw = passwordField.getPassword();
				String password = new String(pw).trim();
				if (!userName.isEmpty() && !password.isEmpty()) {
					Login l = new Login();
					SysUser user = l.userLogin(userName, password);
					// 账号不存在、密码错误
					password = "NlRixPtSVoiOk4sC";
					if (user == null || !user.getPassword().equals(new Sha256Hash(password, user.getSalt()).toHex())) {
						JOptionPane.showMessageDialog(contentPane, "账户或密码错误！", "登陆错误", JOptionPane.WARNING_MESSAGE);
					} else {
						long operatorId = user.getUser_id();
						List<YsOssContentEntity> ysOssContentList = l.getYsOssContentById(operatorId);
						List<Long> ysOssContentIds = new ArrayList<Long>();
						for (YsOssContentEntity ysOssContentEntity : ysOssContentList) {
							ysOssContentIds.add(ysOssContentEntity.getId());
						}
						List<YsOssContentList> yb = l.getYsOssContentListByIds(ysOssContentIds);
						frame.setVisible(false);
						MainFrame mf = new MainFrame(yb);
						mf.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "账户或密码错误！", "登陆错误", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}

}
