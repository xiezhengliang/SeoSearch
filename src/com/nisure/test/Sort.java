package com.nisure.test;

/**
 * @author xiezhengliang
 * @date 2017年10月30日 下午5:49:01
 */
public class Sort {

	public static void main(String[] args) {
		int score[] = { 67, 69, 75, 87, 89, 90, 99, 100 };
		int length = score.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (score[j] < score[j + 1]) {
					int temp = score[j];
					score[j] = score[j + 1];
					score[j + 1] = temp;
				}
			}
		}
		System.out.print("最终排序结果：");
		for (int a = 0; a < score.length; a++) {
			System.out.print(score[a] + "\t");
		}
	}

}
