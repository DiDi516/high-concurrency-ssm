package com.wuzhazha.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * web应用配置
 * @Author:wuzhazha
 * @Date: 2018/8/12 16:28
 * @Description:
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    /**
     * spring ioc 环境配置
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //配置spring ioc资源
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * 配置DispatcherServlet环境配置
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * DispatchServlet拦截请求配置
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"*.do"};
    }

    /**
     * 上传文件配置
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //配置上传文件路径
        String filePath = "e:/mvc/uploads";
        //5MB
        Long singleMax = (long) (5*Math.pow(2,20));
        //10MB
        Long totalMax = (long) (10*Math.pow(2,20));
        //设置上传文件设置
        registration.setMultipartConfig(new MultipartConfigElement(filePath,singleMax,totalMax,0));
    }
}
