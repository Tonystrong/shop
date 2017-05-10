package com.jyx.s2sh.shop.service;

import java.io.File;

public interface FileUploadUtils {

	String[] getBankName();

	String upload(File file, String filename);

}
