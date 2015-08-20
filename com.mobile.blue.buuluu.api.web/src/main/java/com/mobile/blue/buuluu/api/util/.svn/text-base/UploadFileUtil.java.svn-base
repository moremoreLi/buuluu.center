package com.mobile.blue.buuluu.api.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mobile.blue.buuluu.api.common.util.DateUtil;
import com.mobile.blue.buuluu.api.common.util.PropertiesUtil;


public class UploadFileUtil {
	/**
	 * 系统路径分隔符
	 */
	public static final char FILE_SPT = File.separatorChar;

	/**
	 * get upload path from upload.proerties
	 */
	public static final String UPLOADPATH_PATH = "PATH";

	public static final String UPLOADPATH_FILE_PATH = PropertiesUtil.getProperty("USER_BINDFILE_UPLOAD_PATH");

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:MM:dd");
	private static Log logger = LogFactory.getLog(FileUploadUtil.class);
	private static long sizeMax = 5242880l;

	public final static String separator = "/";
	public final static String IMAGE_PATH = UPLOADPATH_FILE_PATH + separator;

	public static Map<String, String> uploadFile(HttpServletRequest request, String userId) throws Exception {
		return uploadFile(request, UPLOADPATH_FILE_PATH, userId);
	}

	/**
	 * 保存文件 ＠param stream ＠param path ＠param filename ＠throws IOException
	 * 
	 * @throws SizeLimitExceededException
	 */
	public static String SaveFileFromFile(MultipartFile file, String path, String userId) throws IOException, SizeLimitExceededException {

		String uploadpath = PropertiesUtil.getProperty(UPLOADPATH_PATH);
		// temp 是没用到的。只是让其深度创建其上级目录。是过渡用的，不会创建的
		createFilePath(uploadpath + path + "/temp");
		if (file.isEmpty()) {
			logger.info("file not exits");
			return null;
		}

		long fileSize = file.getSize();

		if (fileSize > sizeMax) {
			String message = String.format("the request was rejected because its size (%1$s) exceeds the configured maximum (%2$s)", fileSize, sizeMax);
			throw new SizeLimitExceededException(message, fileSize, sizeMax);
		}

		String filename = userId + "_" + DateUtil.getCurrentDateStr("yyyy-MM-dd HH-mm-ss");
		String originalFilename = file.getOriginalFilename();
		filename += originalFilename.substring(originalFilename.indexOf("."));	
		logger.info("filename:" + filename);

		// FileOutputStream fileOS = null ;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			int size;
			byte[] buffer = new byte[2048];
			bis = new BufferedInputStream(file.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream(uploadpath + path + filename), buffer.length);
			while ((size = bis.read(buffer, 0, buffer.length)) != -1) {
				bos.write(buffer, 0, size);
			}
			
			bos.flush();
			bos.close();
			bis.close();
		} catch (Exception e) {
			bos.close();
			bis.close();
		} finally {
			if (bis != null) {
				bis.close();
			}
			if (bos != null) {
				bos.close();
			}
		}
		logger.info("upload file:" + (path + filename) + " on " + dateFormat.format(new java.util.Date()));

		return filename;
	}

	public static Map<String, String> uploadFile(HttpServletRequest request, String filePath, String userId) throws Exception {
		Map<String, String> fileNames = new HashMap<String, String>();
		String path = filePath;
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		Map<String, MultipartFile> files = multipartRequest.getFileMap();
		Set<String> keys = files.keySet();
		Iterator<String> iterator = keys.iterator();

		logger.info("update file iterator.hasNext:" + iterator.hasNext());

		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			MultipartFile file = files.get(key);

			String filename = SaveFileFromFile(file, path, userId);
			if (!StringUtils.isEmpty(filename)) {
				fileNames.put(key, filePath + filename);
			}
		} // end for
		return fileNames;
	}

	private static void createFilePath(String path) {
		File file = new File(path);
		// 寻找父目录是否存在
		File parent = new File(file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator)));
		// 如果父目录不存在，则递归寻找更上一层目录
		if (!parent.exists()) {
			createFilePath(parent.getPath());
			// 创建父目录
			parent.mkdirs();
		}
		// return file;
	}

	public static boolean isEmpty(MultipartFile file) {
		return (file == null || file.isEmpty());
	}
//
//	public static boolean uploadSuccess(MultipartFile file, String path, String userId) {
//		String uploadpath = PropertiesUtil.getProperty(UPLOADPATH_PATH);
//		
//		String filename = userId + "_" + DateUtil.getCurrentDateStr("yyyy-MM-dd HH-mm-ss");
//		String originalFilename = file.getOriginalFilename();
//		filename += originalFilename.substring(originalFilename.indexOf("."));	
//		uploadpath + path + filename
//	}
}
