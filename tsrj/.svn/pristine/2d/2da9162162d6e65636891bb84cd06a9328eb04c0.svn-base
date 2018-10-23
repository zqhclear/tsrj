package org.tsrj.common.utils;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class NickNameFilter {

	private static List<String> minGanCiList;
	
	private static List<String> getSensitiveWordList() throws Exception{
		if(minGanCiList==null){
			synchronized(NickNameFilter.class){
				if(minGanCiList==null){
					String fileName = "olk/" + "sensitiveVocabulary.txt";
					String path = NickNameFilter.class.getClassLoader().getResource(fileName).getPath();
					File isfile = new File(path);
					// 判断文件是否存在
					if (!isfile.exists()) {
						throw new RuntimeException("敏感词库文件不存在");
					}else{
						minGanCiList = FileUtils.readLines(isfile);
					}
				}
			}
		}
		return minGanCiList;
	}
	
	public static Boolean nickNameFilter(String nickName) {
		try {
			List<String> minGanCiList = getSensitiveWordList();
			if (Collections3.isNotEmpty(minGanCiList)) {
				for (String s : minGanCiList) {
					if (nickName.indexOf(s) != -1) {
						return true;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return true;
		}
		return false;
	}
	
	/**
	 * 过滤表情
	 * 
	 * @param source
	 * @return
	 */
	public static Boolean filterEmoji(String source) {

		if (source != null) {
			Pattern emoji = Pattern.compile("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]",
					Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);

			Matcher emojiMatcher = emoji.matcher(source);

			if (emojiMatcher.find()) {
				return true;
			}
			return false;
		}
		return false;

	}
	
	/**
	 * 过滤表情
	 * 
	 * @param source
	 * @return
	 */
	public static String filterEmoji1(String source) {

		if (source != null) {
			Pattern emoji = Pattern.compile("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]",
					Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);

			Matcher emojiMatcher = emoji.matcher(source);

			if (emojiMatcher.find()) {
				source = emojiMatcher.replaceAll("");
				return source;
			}
			return source;
		}
		return source;

	}

	public static void main(String[] args) {
		new NickNameFilter();
		Boolean l = NickNameFilter.nickNameFilter("");
		System.out.println(nickNameFilter("1人人爱家"));
	}
}
