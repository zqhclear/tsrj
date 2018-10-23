/**
 * 
 */
package org.tsrj.service.wxchat.enums;

/**
 * @desc
 * @author zhongqionghua
 * @date 2018年2月9日
 */
public enum WXUrlEnums {
	APPID("wx78a2bb1035625682", "appid", ""),
	APPSECRET("70489bf31d4d7fcc3ef1fd13de610e89", "appsecret", ""),
	GET_ACCESS_TOKEN("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID.getUrl() + "&secret=" + APPSECRET.getUrl(), "获取token_access", "get"),
	
	/**
	 * 用户相关
	 */
	ATTENTION_LIST("https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID", "获取用户列表", "get"),
	ATTENTION_BY_OPENID("https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN", "获取用户信息", "get"),
	ATTENTIONLIST_BY_OPENIDS("https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN", "批量获取用户信息", "get"),
	ATTENTION_REMARK("https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN", "给用户添加备注", "post"),
	
	/**
	 * 黑名单
	 */
	BLACKLIST_GET("https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist?access_token=ACCESS_TOKEN", "获取公众号的黑名单列表", "get"),
	BLACKLIST_ADD("https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist?access_token=ACCESS_TOKEN", "添加黑名单", "post"),
	BLACKLIST_DEL("https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist?access_token=ACCESS_TOKEN", "取消拉黑", "post"),
	
	/**
	 * 用户标签
	 */
	ADD_TAG("https://api.weixin.qq.com/cgi-bin/tags/create?access_token=ACCESS_TOKEN", "添加用户标签", "post"),
	GET_TAGS("https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN", "获取已有标签", "get"),
	UPDATE_TAGS("https://api.weixin.qq.com/cgi-bin/tags/update?access_token=ACCESS_TOKEN", "编辑标签", "post"),
	DEL_TAG("https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=ACCESS_TOKEN", "删除已有标签", "post"),
	GET_USER_BYTAG("https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=ACCESS_TOKEN", "获取标签下的粉丝数量", "get"),
	STAMP_TAG_FOR_USER("https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=ACCESS_TOKEN", "批量为用户打标签", "get"),
	CACEL_TAG_FRO_USER("https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=ACCESS_TOKEN", "批量为用户取消标签", "post"),
	GET_ALLTAG_FOR_USER("https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=ACCESS_TOKEN", "获取用户的所有标签", "post"),
	
	/**
	 * 素材管理 注意点：
	 * 1、临时素材media_id是可复用的。
	 * 2、媒体文件在微信后台保存时间为3天，即3天后media_id失效。
	 * 3、上传临时素材的格式、大小限制与公众平台官网一致。
	 * 
	 * 图片（image）: 2M，支持PNG\JPEG\JPG\GIF格式
	 * 语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
	 * 视频（video）：10MB，支持MP4格式
	 * 缩略图（thumb）：64KB，支持JPG格式
	 */
	ADD_TEMPORARY_MEDIA("https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE", "新增临时素材", "post"),
	GET_TEMPORARY_MEDIA("https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID", "获取临时素材", "get"),
	ADD_PERMANENT_MEDIA("https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN", "新增永久素材", "post"),
	GET_PERMANENT_MEDIA("https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN", "获取永久素材", "get"),
	DEL_PERMANENT_MEDIA("https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN", "删除永久素材", "post"),
	UPDATE_PERMANENT_MEDIA("https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN", "修改永久图文素材", "post"),
	/** 开发者可以根据本接口来获取永久素材的列表，需要时也可保存到本地。 */
	GET_ALL_MEDIA_NUMBER("https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN", "获取素材总数", "get"),
	/** 只可以获取永久素材 */
	GET_MEDIALIST("https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN", "获取素材列表" ,"get"),
	
	/**
	 * 菜单管理
	 */
	ADD_MENU("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN", "新建自定义菜单", "post"),
	GET_MENU("https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN", "获取自定义菜单接口", "get"),
	DEL_MENU("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOK", "删除自定义接口", "post"),
	ADD_INDIVIDUATION_MENU("https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN", "创建个性化菜单", "post"),
	DEL_INDIVIDUATION_MENU("https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN", "删除个性化菜单", "post"),
	CHECK_INDIVIDUATION_MENU("https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN", "测试个性化菜单", "post"),
	GET_INDIVIDUATION_MENU_INFO("https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN", "获取自定义菜单配置接口", "get");
	
	
	public String getReqeustMethod() {
		return reqeustMethod;
	}
	public void setReqeustMethod(String reqeustMethod) {
		this.reqeustMethod = reqeustMethod;
	}
	private String url;
	private String desc;
	private String reqeustMethod;
	private WXUrlEnums(String url, String desc, String reqeustMethod) {
		this.url = url;
		this.desc = desc;
		this.reqeustMethod = reqeustMethod;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
