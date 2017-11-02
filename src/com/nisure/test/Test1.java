package com.nisure.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author xiezhengliang
 * @date 2017年10月25日 下午5:46:39
 */
public class Test1 {

	public Test1() {
		JFrame f = new JFrame();
		Object[][] playerInfo = {
				// 创建表格中的数据
				{ "王鹏", 91, 100, 191, "true" }, 
				{ "朱学莲", 82, 69, 151, true }, 
				{ "梅婷", 47, 57, 104, false },
				{ "赵龙", 61, 57, 118, false }, 
				{ "李兵", 90, 87, 177, true } };
		// 创建表格中的横标题
		String[] Names = { "姓名", "语文", "数学", "总分", "及格" };
		// 以Names和playerInfo为参数，创建一个表格
		JTable table = new JTable(playerInfo, Names);
		// 设置此表视图的首选大小
		table.setPreferredScrollableViewportSize(new Dimension(550, 100));
		// 将表格加入到滚动条组件中
		JScrollPane scrollPane = new JScrollPane(table);
		f.getContentPane().add(scrollPane, BorderLayout.CENTER);
		// 再将滚动条组件添加到中间容器中
		f.setTitle("表格测试窗口");
		f.pack();
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		Test1 t = new Test1();
	}
}
