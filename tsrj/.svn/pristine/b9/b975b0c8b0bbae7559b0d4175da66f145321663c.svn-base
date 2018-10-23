package org.tsrj.common.web.converter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;


/**
 * 
 * @author zhongqionghua
 * @date 2018年02月09日 上午11:23:26   
 *
 */
public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

	public final static Charset charset = Charset.forName("UTF-8");

	private SerializerFeature[] serializerFeature;
	private CustomPropertyPreFilter customPropertyPreFilter;

	public FastJsonHttpMessageConverter() {
		super(new MediaType("application", "json", charset), new MediaType("application", "*+json", charset));
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		InputStream in = inputMessage.getBody();
		byte[] buf = new byte[1024];
		for (;;) {
			int len = in.read(buf);
			if (len == -1) {
				break;
			}
			if (len > 0) {
				baos.write(buf, 0, len);
			}
		}
		byte[] bytes = baos.toByteArray();
		return JSON.parseObject(bytes, 0, bytes.length, charset.newDecoder(), clazz);
	}

	@Override
	protected void writeInternal(Object obj, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		String json = "";
		if (customPropertyPreFilter != null) {
			json = CustomJson.toJSONStringWithCustom(obj, customPropertyPreFilter, serializerFeature);
		} else {
			json = JSON.toJSONString(obj, serializerFeature);
		}
		OutputStream out = outputMessage.getBody();
		byte[] bytes = json.getBytes(charset);
		out.write(bytes);
	}

	public SerializerFeature[] getSerializerFeature() {
		return serializerFeature;
	}

	public void setSerializerFeature(SerializerFeature[] serializerFeature) {
		this.serializerFeature = serializerFeature;
	}

	public CustomPropertyPreFilter getCustomPropertyPreFilter() {
		return customPropertyPreFilter;
	}

	public void setCustomPropertyPreFilter(CustomPropertyPreFilter customPropertyPreFilter) {
		this.customPropertyPreFilter = customPropertyPreFilter;
	}

}
