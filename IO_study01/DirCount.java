package com.sxt.io;

import java.io.File;
/**
 * 
 * @author wanghan
 *使用面向对象：统计文件夹的大小
 *
 */
public class DirCount {
	//大小
	private long len;
	//文件夹
	private String path;
	//文件的个数
	private int fileSize;
	//文件夹的个数
	private int dirSize;
	//源
	private File src;
	public DirCount(String path) {
		this.path = path;
		this.src = new File(path);
		count(this.src);
	}
	
	public static void main(String[] args) {
		DirCount dir = new DirCount("D:\\JavaWorkplace\\IO_study01");
		System.out.println(dir.getLen()+ "-->"+ dir.getFileSize()+ "-->" +dir.getDirSize());
		
		DirCount dir2 = new DirCount("D:\\JavaWorkplace\\IO_study01//src");
		System.out.println(dir2.getLen()+ "-->"+ dir2.getFileSize()+ "-->" +dir2.getDirSize());
	}

	public long getLen() {
		return len;
	}

	public void setLen(long len) {
		this.len = len;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public int getDirSize() {
		return dirSize;
	}

	public void setDirSize(int dirSize) {
		this.dirSize = dirSize;
	}
	
	//统计大小
	private void count(File src) {
		//获取大小
		if(null!=src&&src.exists()) {
			if(src.isFile()) {	//大小
				len += src.length();
				this.fileSize++;
			} else {	//子孙级
				this.dirSize++;
				for(File s: src.listFiles()) {
					count(s);
				}
				
			}
		}
	
	}


	
	
}
