package loc.udp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
//1.图片写入到字节数组
	//图片到程序 FileInputStream
	//程序到字节数组 ByteArrayOutputStream
	
	public static byte[] fileToByteArray(String filePath) {
		//创建源
		File srcFile = new File(filePath);
		byte[] dest = null;
		//选择流
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try {
			is = new FileInputStream(srcFile);
			baos = new ByteArrayOutputStream();
			//分段读取
			byte[] flush = new byte[1024];
			int len =-1;
			while ((len=is.read(flush))!=-1) {
				baos.write(flush,0,len);
			}
			baos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return baos.toByteArray();
	}
	//2.字节数组写出图片
	//字节数组到程序 ByteArrayInputStream
	//程序到图片 FileOutputStream
	public static void byteArrayToFile(byte[] src,String filePath) {
		File destFile = new File(filePath);
		InputStream is = null;
		OutputStream os =null;
		try {
			is=new ByteArrayInputStream(src);
			os=new FileOutputStream(filePath);
			byte[] flush = new byte[1024];
			int len = -1;
			while ((len=is.read(flush))!=-1) {
				os.write(flush,0,len);
			}
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}