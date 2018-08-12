package com.wuzhazha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wuzhazha
 * @Date: 2018/8/12 16:31
 * @Description:
 */
@Configuration
//定义springmvc包扫描
@ComponentScan(value = "com.*",includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class})})
//启动mvc配置
@EnableWebMvc
public class WebConfig {

    /**
     * 通过注解@Bean初始化视图解析器
     * @return
     */
    @Bean(name="internalResourceViewResolver")
    public ViewResolver initViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * 初始化RequestMappingHandlerAdapter 并加载http的json转换器
     * @return
     */
    @Bean(name="requestMappingHandlerAdapter")
    public HandlerAdapter initRequestMappingHandlerAdapter(){
        //创建RequestMappingHandlerAdapter适配器
        RequestMappingHandlerAdapter rmhd = new RequestMappingHandlerAdapter();
        //HTTP JSON 转换器
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        //MappingJackson2HttpMessageConverter 接收JSON类型消息的转换
        MediaType mediaType = MediaType.APPLICATION_JSON;
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(mediaType);
        //加入转换器的支持类型
        jsonConverter.setSupportedMediaTypes(mediaTypes);
        //往适配器加入json转换器
        rmhd.getMessageConverters().add(jsonConverter);
        return rmhd;
    }
}
