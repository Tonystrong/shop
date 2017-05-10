package com.jyx.s2sh.shop.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jyx.s2sh.shop.service.FileUploadUtils;

@Component("fileUploadUtils")
public class FileUploadUtilsImpl implements FileUploadUtils{
	
	@Value("#{public.uploadPath}")  
	private String filepath;
	@Value("#{public.payPath}")
	private String payPath;
	
	// 注入"值"  配置文件的加载存储到 applicationContext-db.xml 中
	//没有注解的时候，就在这个添加set方法即可
//	public void setFilepath(String filepath) {
//		this.filepath = filepath;
//	}
	
	@Override
	public String upload(File file, String filename) {
		//获得文件后缀，生成UUID命名文件
		String ext = FilenameUtils.getExtension(filename);
		String uuidName = UUID.randomUUID().toString()+ "." +ext;
		File savepath = new File(filepath);
		if (!savepath.exists()) {
			savepath.mkdirs();
		}
		System.out.println("+++++++++++++++++======="+ServletActionContext.getServletContext().getRealPath("/upload"));
		//拷贝文件到目录下
		try {
			FileUtils.copyFile(file, new File(filepath, uuidName));
			return uuidName;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			file.delete();
		}
	}
	
	@Override
	public String[] getBankName() {
		File file = new File(payPath);
		String[] bankName = file.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(".gif");
			}
		});
		return bankName;
	}
}
