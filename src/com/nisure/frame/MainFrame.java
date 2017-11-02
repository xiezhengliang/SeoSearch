package com.nisure.frame;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.nisure.dao.BaiduEngineService;
import com.nisure.model.KeywordModel;
import com.nisure.model.RankModel;
import com.nisure.model.RequestData;
import com.nisure.model.TimingRankingEntity;
import com.nisure.model.YsOssContentList;
import com.nisure.model.YsOssPathEntity;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;

/**
 * @author xiezhengliang
 * @date 2017年10月17日 上午11:04:22
 */
public class MainFrame extends JFrame implements ActionListener {
	private JTable table;
	private JTable table_1;
	KeywordModel km;
	RankModel rm;
	JScrollPane kwjsp;
	JScrollPane rkjsp;
	int m = 0;

	// 定义一些控件
	// JPanel jp1, jp2;
	// JLabel jl1, jl2;
	// JButton jb1, jb2, jb3, jb4;
	// JTable jt;
	// JScrollPane jsp;
	// JTextField jtf;
	// private JTable table;

	/**
	 * Create the frame.
	 */
	public MainFrame(List<YsOssContentList> yb) {
		setTitle("实时排名搜索");
		setBounds(500, 200, 1000, 600);
		getContentPane().setLayout(null);
		// 创建模型对象
		km = new KeywordModel(yb);
		table = new JTable(km);
		// table.setBounds(10, 60, 240, 403);
		kwjsp = new JScrollPane(table);
		kwjsp.setBounds(10, 60, 240, 478);
		getContentPane().add(kwjsp);

		List<TimingRankingEntity> treList = new ArrayList<TimingRankingEntity>();
		rm = new RankModel(treList);
		table_1 = new JTable(rm);
		rkjsp = new JScrollPane(table_1);
		rkjsp.setBounds(260, 60, 714, 478);
		getContentPane().add(rkjsp);

		JLabel lblNewLabel = new JLabel("所有关键词：");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 27, 108, 29);
		getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("关键词排名：");
		label.setFont(new Font("黑体", Font.PLAIN, 18));
		label.setBounds(260, 27, 108, 29);
		getContentPane().add(label);

		JButton btnNewButton = new JButton("开始");
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 18));
		btnNewButton.setBounds(737, 10, 93, 29);
		getContentPane().add(btnNewButton);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Thread t = new Thread(new Runnable() {
					public void run() {
						RequestData req = new RequestData();
						Login l = new Login();
						List<YsOssPathEntity> ysOssPathList = l.queryYsOssPathList(yb);
						List<String> list = new ArrayList<String>();
						for (YsOssPathEntity yope : ysOssPathList) {
							list.add(yope.getLink_path());
						}
						req.setLinkUrlList(list);
						req.setEnginconfig(l.getEngineConfig("baidu"));// 搜索引擎的配置
						req.setStartPage(1); // 页码默认从1开始
						req.setTotalNumber(300);
						BaiduEngineService bes = new BaiduEngineService();
						
						for (YsOssContentList yocl : yb) {
							if (yocl.getIdentify() != null) {
								req.setContentListId(yocl.getYsOssContentId());
								req.setIdentyCode(yocl.getIdentify());
								req.setKeywords(yocl.getKeyword());
								req.setUserAgent(
										"Mozilla/5.0 (Macintosh;Intel Mac OS X 10_10_1) AppleWebKit/537.36(KHTML, like Gecko) Chrome/41.0.2227.1Safari/537.36");
								TimingRankingEntity extract = bes.extract(req);
								if(extract!=null){
									treList.add(extract);
								}
								rm = new RankModel(treList);
								table_1.setModel(rm);
							}
						}
					}
				});
				t.start();

			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
