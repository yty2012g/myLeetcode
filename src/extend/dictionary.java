package extend;

import java.util.*;
/*
 * 2016.5.9
 * �ֵ���ȫ�����㷨��
 * �ҵ�һ�����е���һ���ֵ����Ϊ�ĸ����衣
 * ��һ�����������ǰɨ�裬����ڵ�i��λ�÷��ϵ�i��λ�õ�Ԫ�ش��ڵ�i-1��λ�õ�Ԫ�أ����¼��i-1��Ԫ�ص��±�Ϊindex
 * �ڶ������ӵ�i��λ�����ɨ�裬�ҵ����һ�����ڵ�i-1��Ԫ�ص�Ԫ�أ�λ�ü�¼ΪindexB
 * ������������index��Ԫ�غ͵�indexB��Ԫ�ؽ���
 * ���Ĳ�����indexλ���Ժ��Ԫ�ط���
 */
public class dictionary {
	public void dic() {
		ArrayList<Integer> array = new ArrayList<Integer>();
		int res = 1;
		for (int i = 1; i <= 5; i++) {
			array.add(i);
			res = res * i;
		}
		for (int i = 1; i <= res; i++) {
			int index = 0;
			int indexB = 0;
			for (int j = array.size() - 1; j > 0; j--) {
				if (array.get(j) > array.get(j - 1)) {
					index = j - 1;
					for (int k = j; k < array.size(); k++) {
						if (array.get(k) > array.get(index))
							indexB = k;
					}
					int temp = array.get(index);
					array.set(index, array.get(indexB));
					array.set(indexB, temp);
					reverse(array, index + 1);
					break;
				}
			}
			System.out.println(array);
		}
	}

	public void reverse(ArrayList<Integer> array, int length) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = length; i < array.size(); i++) {
			stack.push(array.get(i));
		}
		for (int i = length; i < array.size(); i++) {
			array.set(i, stack.pop());
		}
	}
}
