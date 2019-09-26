package com.imooc.ad.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Created by Qinyi.
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * 消息转换器
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>>
                                                       converters) {
        //清除消息转换器，表示只使用这一个消息转换器
        converters.clear();
        //可以将java对象转换成json对象
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
