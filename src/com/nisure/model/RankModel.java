package com.nisure.model;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

/**
 * @author xiezhengliang
 * @date 2017年11月1日 下午5:31:01
 */
public class RankModel extends AbstractTableModel {

	// rowData存放行数据，columnNames存放列名
	Vector rowData, columnNames;
	
	public RankModel(List<TimingRankingEntity> tre) {
		this.init(tre);
	}

	public void init(List<TimingRankingEntity> tre) {
		// 设置列名
		columnNames = new Vector();
		columnNames.add("关键词");
		columnNames.add("排名");
		columnNames.add("搜索引擎名");
		columnNames.add("时间");
		
		
		// rowData存放多行
		rowData = new Vector();
		for (TimingRankingEntity trk : tre) {
			Vector row = new Vector<String>();
			row.add(trk.getKeyword());
			row.add(trk.getSite());
			row.add(trk.getEngineName());
			row.add(trk.getSearchTime());
			rowData.add(row);
		}
		

	}
	// 得到共有多少列
	@Override
	public int getColumnCount() {
		return this.columnNames.size();
	}
	// 得到共有多少行
	@Override
	public int getRowCount() {
		return this.rowData.size();
	}
	
	// 得到某行某列的数据
	@Override
	public Object getValueAt(int row, int column) {
		return ((Vector) (this.rowData.get(row))).get(column);
	}
	
	 // 得到属性名字
	 public String getColumnName(int column) {
	 Object object = this.columnNames.get(column);
	 return (String) this.columnNames.get(column);
	 }

}
