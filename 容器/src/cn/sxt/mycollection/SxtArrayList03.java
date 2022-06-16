package cn.sxt.mycollection;
/**
 * 自定义实现一个ArrayList，体会底层原理
 * 增加数组扩容
 * @author wanghan
 *
 */
public class SxtArrayList03 {
	private Object[] elementData;
	private int size;
	
	private static final int DEFALT_CAPACITY = 10;
	
	public SxtArrayList03() {
		elementData = new Object[DEFALT_CAPACITY];
	}
	
	public SxtArrayList03(int capacity) {
		elementData = new Object[capacity];
	}

	public <E> void add(E element) {
		//什么时候扩容
		if(size == elementData.length) {
			//怎么扩容
			Object[] newArray = new Object[elementData.length+ (elementData.length>>1)];
			System.arraycopy(elementData,0, newArray,0, elementData.length);
			elementData = newArray;
		}
		elementData[size++] = element;
		  
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		//[a,b,c]
		sb.append("[");
		for(Object obj:elementData) {
			sb.append(obj);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		SxtArrayList03 s1 = new SxtArrayList03(20);
		for (int i = 0; i<40; i++) {
			s1.add("gao" + i);
		}
		s1.add("aa");
		s1.add("bb");
		
		System.out.println(s1.toString());
	}
}
