package cn.interview.code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

	public static void main(String args[]) {
		copyFile("/home/images/22281994.jpg", "/home/images/sex.jpg");
	}

	/**
	 * 
	 * 简要描述方法的作用
	 *
	 * @author 30456
	 * @date 2018年8月1日
	 * @param oldFile
	 *            文件路径
	 * @param newFile
	 */
	public static void copyFile(String oldFile, String newFile) {
		File file = new File(oldFile);
		FileInputStream in = null;
		FileOutputStream out = null;
		/** 文件存在时 **/
		if (file.exists()) {
			try {
				in = new FileInputStream(oldFile);
				try {
					out = new FileOutputStream(newFile);
					byte[] buffer = new byte[1444];
					while (in.read(buffer) != -1) {
						out.write(buffer);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					/** 如果out流有异常,需要关闭**/
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				in.close();
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				/** 如果in流有异常需要先关闭**/
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
