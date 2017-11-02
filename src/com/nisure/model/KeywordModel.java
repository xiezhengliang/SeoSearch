package com.nisure.model;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

/**
 * @author xiezhengliang
 * @date 2017年10月28日 上午9:49:38
 */
public class KeywordModel extends AbstractTableModel {

	// rowData存放行数据，columnNames存放列名
	Vector rowData, columnNames;

	public KeywordModel(List<YsOssContentList> yb) {
		this.init(yb);
	}

	public void init(List<YsOssContentList> yb) {
		// 设置列名
		columnNames = new Vector();
		columnNames.add("关键词");
//		columnNames.add("标识码");

		// rowData存放多行
		rowData = new Vector();
		for (YsOssContentList yocl : yb) {
			Vector hang = new Vector<String>();
			hang.add(yocl.getKeyword());
//			hang.add("aaa");
			// 加入到rowData中
			rowData.add(hang);
		}
	}

	public int getColumnCount() {
		// System.out.println("rowData.size():" + this.rowData.size());
		return this.columnNames.size();
	}

	public int getRowCount() {
		// System.out.println("columnNames.size():" + columnNames.size());
		return this.rowData.size();
	}

	// 得到某行某列的数据
	public Object getValueAt(int row, int column) {
		return ((Vector) (this.rowData.get(row))).get(column);
	}

	 // 得到属性名字
	 public String getColumnName(int column) {
	 Object object = this.columnNames.get(column);
	 return (String) this.columnNames.get(column);
	 }

}
