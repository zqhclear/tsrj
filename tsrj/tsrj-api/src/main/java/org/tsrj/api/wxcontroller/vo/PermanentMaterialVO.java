package org.tsrj.api.wxcontroller.vo;

/**
 * 上传永久图文信息vo
 * @author zhongqionghua
 *
 */
public class PermanentMaterialVO {
	private String title; //标题
	private String thumbMediaId; //图文消息的封面图片素材id（必须是永久mediaID）
	private String author; //作者
	private String digest; //图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空。如果本字段为没有填写，则默认抓取正文前64个字。
	private boolean showCoverPic; //是否显示封面，0为false，即不显示，1为true，即显示
	private String content;	//图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS,涉及图片url必须来源 "上传图文消息内的图片获取URL"接口获取。外部图片url将被过滤。
	private String contentSourceUrl; //图文消息的原文地址，即点击“阅读原文”后的URL
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public boolean isShowCoverPic() {
		return showCoverPic;
	}
	public void setShowCoverPic(boolean showCoverPic) {
		this.showCoverPic = showCoverPic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentSourceUrl() {
		return contentSourceUrl;
	}
	public void setContentSourceUrl(String contentSourceUrl) {
		this.contentSourceUrl = contentSourceUrl;
	}
	
	
}
