package org.tsrj.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tsrj.common.ConfigUtil;

/**
 */
public class FileInfoUtil {

	public static Logger logger = LoggerFactory.getLogger(FileInfoUtil.class);
	/**
	 * 文件后缀-pdf
	 */
	public static final String FILE_SUFFIX_PDF = ".pdf";
	/**
	 * 文件后缀-vm
	 */
	public static final String FILE_SUFFIX_VM = ".vm";
	/**
	 * 文件后缀-html
	 */
	public static final String FILE_SUFFIX_HTML = ".html";
	/**
	 * 文件后缀-htm
	 */
	public static final String FILE_SUFFIX_HTM = ".htm";

	/**
	 * 获得文件类型(文件后缀),要么是文件夹，要么是文件后缀
	 * 
	 * @param path
	 * @return
	 */
	public static String getFileSuffix(String path) {
		File file = new File(path);
		String info = null;
		if (file.isFile()) {
			info = path.substring(path.lastIndexOf(".") + 1, path.length())
					+ "文件";
		}
		if (file.isDirectory()) {
			info = "文件夹";
		}
		return info;
	}

	/**
	 * 获得文件的大小
	 * 
	 * @param path
	 * @return
	 */
	public static long getFileSize(String path) {
		File f = new File(path);
		long size = 0;
		FileInputStream fis = null;
		try {
			if (f.exists()) {
				if (f.isDirectory()) {
					File flist[] = f.listFiles();
					for (int i = 0; i < flist.length; i++) {
						size = size + getFileSize(flist[i].getPath());
					}
				} else {
					fis = new FileInputStream(f);
					size = fis.available();
					fis.close();
				}
			} else {
				f.createNewFile();
				System.out.println("文件不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	/**
	 * 转换文件的大小以B,KB,M,G等计算
	 * 
	 * @param fileS
	 * @return
	 */
	public static String FormetFileSize(long fileS) {// 转换文件大小
		DecimalFormat df = new DecimalFormat("#.000");
		String fileSizeString = "";
		if (fileS < 1024) {
			fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024) + "K";
		} else if (fileS < 1073741824) {
			fileSizeString = df.format((double) fileS / 1048576) + "M";
		} else {
			fileSizeString = df.format((double) fileS / 1073741824) + "G";
		}
		return fileSizeString;
	}

	/**
	 * 判断选择的是什么类型的单位，并返回该单位代表的Byte值
	 * 
	 * @param unit
	 * @return
	 */
	public static long judgeUnit(String unit) {
		Long value;
		if (unit.equals("B")) {
			value = 1L;
		} else if (unit.equals("K")) {
			value = 1024L;
		} else if (unit.equals("M")) {
			value = 1048576L;
		} else {
			value = 1073741824L;
		}
		return value;
	}

	// 获得文件夹内文件的个数。
	public static long getFileSize(File f) {
		long size = 0;
		File flist[] = f.listFiles();
		for (int i = 0; i < flist.length; i++) {
			if (flist[i].isDirectory()) {
				size = size + getFileSize(flist[i]);
			} else {
				size = size + flist[i].length();
			}
		}
		return size;
	}

	/**
	 * 写文件
	 * 
	 * @param input
	 *            文件输入流
	 * @param fileName
	 *            文件名称
	 * @param path
	 *            文件存放的路径
	 * @param prefix
	 *            前缀
	 * @return
	 * @throws IOException
	 */
	public static File writeFile(InputStream input, String fileName,
			String path, String prefix) throws IOException {
		File file = new File(path);
		// 检查文件路径是否存在
		if (!file.exists()) {
			file.mkdirs();
		}
		// 后缀
		String suffix = fileName.substring(fileName.lastIndexOf("."),
				fileName.length());
		File outFile = null;
		boolean outFileExists = true;
		// 确保文件名称唯一性
		do {
			if (StringUtils.isNotBlank(prefix)) {
				fileName = prefix + "_" + Identities.randomBase62(10) + suffix;
			} else {
				fileName = Identities.randomBase62(10) + suffix;
			}
			String filePath = file.getPath() + File.separator + fileName;
			outFile = new File(filePath);
			outFileExists = outFile.exists();
		} while (outFileExists);
		// 把文件写入指定目录
		FileOutputStream output = new FileOutputStream(outFile);
		IOUtils.copy(input, output);
		// 关闭输出流
		IOUtils.closeQuietly(output);
		return outFile;
	}

	/**
	 * 写文件
	 * 
	 * @param input
	 *            文件输入流
	 * @param fileName
	 *            文件名称
	 * @param path
	 *            文件存放的路径
	 * @return
	 * @throws IOException
	 */
	public static File writeFile(InputStream input, String fileName, String path)
			throws IOException {
		return writeFile(input, fileName, path, null);
	}

	/**
	 * 将base64转换成文件,并返回相对uri保存到数据库
	 * 
	 * @param base64Str
	 * @param relativeUri
	 * @return
	 * @throws IOException
	 */
	public static String saveBase64ToFile(String base64Str, String relativeUri)
			throws IOException {
		return saveBase64ToFile(base64Str, relativeUri, true);
	}

	/**
	 * 将base64转换成文件,并返回相对uri保存到数据库
	 * 
	 * @param base64Str
	 * @param relativeUri
	 * @return
	 * @throws IOException
	 */
	public static String saveBase64ToFile(String base64Str, String relativeUri,
			boolean simpleImgUrl) throws IOException {
		String fileName = UUID.randomUUID().toString().replaceAll("-", "")
				+ "." + getFileSuffixByBase64(base64Str)[1];
		File file = new File(ConfigUtil.getInstance().getFileUploadPath() + "/"
				+ relativeUri, fileName);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		String _base64Str = base64Str;
		int idx = _base64Str.indexOf("base64,");
		if (idx > 0 && idx < 20) {
			_base64Str = base64Str.substring(idx + 7);
		}
		Base64.decodeToFile(_base64Str, file);
		String url = OSSUtil.uploadImageToOSS(relativeUri + "/" + fileName,
				file.getPath());
		return simpleImgUrl ? OSSUtil.getSimpleImageUrl(url) : url;
	}

	/**
	 * 从Base64字符串中获取出来文件的类型
	 * 
	 * @param base64Str
	 * @return
	 */
	public static String[] getFileSuffixByBase64(String base64Str) {
		int idx = base64Str.indexOf(";base64,");
		String type = base64Str.substring(5, idx);
		return type.split("/");
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @param pFileName
	 * @return
	 */
	public static String getFileExt(String pFileName) {
		String pExt = "";
		String[] lFrags = pFileName.split("\\.");
		if (lFrags.length >= 2) {
			pExt = lFrags[lFrags.length - 1];
		}
		return pExt;
	}

	// 创建文件上传路径
	public static void mkdir(String path) {
		File fd = null;
		try {
			fd = new File(path);
			if (!fd.exists()) {
				fd.mkdirs();
			}
		} catch (Exception e) {
			logger.error("创建文件夹出错，path:" + path, e);
		} finally {
			fd = null;
		}
	}

	public static String getContractFolder(String memberId, Date pDate) {
		String lKey = "";
		SimpleDateFormat lSdf = new SimpleDateFormat("yyyy-MM-dd");
		String[] lDateFrags = lSdf.format(pDate).split("-");
		lKey += memberId.subSequence(0, 6) + "/" + memberId.substring(6, 8)
				+ "/" + memberId.substring(8, 10) + "/"
				+ memberId.substring(10, 12) + "/" + lDateFrags[0] + "/"
				+ lDateFrags[1] + "/" + lDateFrags[2] + "/";
		return lKey;
	}

	public static String getContractFolderByProject(String memberId, Date pDate) {
		String lKey = "";
		SimpleDateFormat lSdf = new SimpleDateFormat("yyyy-MM-dd");
		String[] lDateFrags = lSdf.format(pDate).split("-");
		lKey += memberId.subSequence(0, 6) + "/" + memberId.substring(6, 9)
				+ "/" + lDateFrags[0] + "/" + lDateFrags[1] + "/"
				+ lDateFrags[2] + "/";
		return lKey;
	}

	/**
	 * 重命名
	 * 
	 * @param filePath
	 * @param append
	 * @return
	 */
	public static String rename(String filePath, String append) {
		String path = filePath.substring(0, filePath.lastIndexOf("/") + 1);
		String name = filePath.substring(filePath.lastIndexOf("/") + 1,
				filePath.length());
		return path + append + name;
	}

	/**
	 * 文件类型判断
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean checkFileType(String fileName) {
		String exts[] = ConfigUtil.getInstance().getUploadFileExts();
		if (exts != null) {
			Iterator<String> type = Arrays.asList(exts).iterator();
			while (type.hasNext()) {
				String ext = type.next();
				if (fileName.toLowerCase().endsWith(ext)) {
					return true;
				}
			}
		}
		return false;
	}

}