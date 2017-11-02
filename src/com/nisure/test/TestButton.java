package com.nisure.test;

import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author xiezhengliang
 * @date 2017年10月18日 下午2:27:21
 */
public class TestButton {

	JFrame frame;
	Container container;

	public TestButton() {
		frame = new JFrame();
		frame.setTitle("按钮事件");
		frame.setLayout(null);
		container = frame.getContentPane();

		JButton btn = new JButton();
		Icon normal = new ImageIcon("C:\\Users\\Administrator\\Desktop\\lx(4).png");
		Icon roll = new ImageIcon("C:\\Users\\Administrator\\Desktop\\lx(4).png");
		Icon down = new ImageIcon("C:\\Users\\Administrator\\Desktop\\lx(4).png");

		btn.setIcon(normal);
		btn.setPressedIcon(down);
		btn.setRolloverIcon(roll);
		btn.setSize(normal.getIconWidth(), normal.getIconHeight());
		btn.setMargin(new Insets(0, 0, 0, 0));
		// btn.setHideActionText(true);
		btn.setFocusPainted(false);
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("点击了按钮呢");
			}
		});
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.print("滑入");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.print("滑出");
			}
		});

		container.add(btn);
		frame.setBounds(100, 100, 300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new TestButton();
	}
}
