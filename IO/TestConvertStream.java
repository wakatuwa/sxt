package IoTechnology;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 字节流转换成字符流
 * @author wanghan
 *
 */
public class TestConvertStream {
	public static void main(String[] args) {
		//创建字符输入流和输出流：使用转换流将字节流转换成字符流
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			//使用字符输入和输出流
			String str = br.readLine();
			//一直读取，直到用户输入了exit为止
			while (!"exit".equals(str)) {
				//写到控制台
				bw.write(str);
				bw.newLine();//换行
				bw.flush();//手动刷新
				//再读一行
				str = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//关闭字符输入和输出流
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
