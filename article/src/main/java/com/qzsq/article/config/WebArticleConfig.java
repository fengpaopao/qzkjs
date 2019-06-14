package com.qzsq.article.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

//上传配置类
//图片放到/F:/fileUpload/后，从磁盘读取的图片数据scr将会变成images/picturename.jpg的格式
@Configuration
public class WebArticleConfig extends WebMvcConfigurationSupport {

    /**
     * 在配置文件中配置的文件保存路径
     */
    @Value("${cbs.imagesPath}")
    private String mImagesPath;


    //解决跨域配置
    @Override
    public void addCorsMappings( CorsRegistry registry ) {
        registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS").maxAge(10000);
    }


    //进行路径映射
    @Override
    public void addResourceHandlers( ResourceHandlerRegistry registry ) {
        if (mImagesPath.equals("") || mImagesPath.equals("${cbs.imagesPath}")) {
            String imagesPath = WebArticleConfig.class.getClassLoader().getResource("").getPath();
//            System.out.print("1.上传配置类imagesPath==" + imagesPath + "/n");
            if (imagesPath.indexOf(".jar") > 0) {
                imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
            } else if (imagesPath.indexOf("classes") > 0) {
                imagesPath = "file:" + imagesPath.substring(0, imagesPath.indexOf("classes"));
            }
            imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/")) + "/images/";
            mImagesPath = imagesPath;
        }
        System.out.print("imagesPath=============" + mImagesPath + "/n");
        //LoggerFactory.getLogger(AppConfig.class).info("imagesPath============="+mImagesPath+"/n");
        registry.addResourceHandler("/images/**").addResourceLocations(mImagesPath);
        // TODO Auto-generated method stub
//        System.out.print("2.上传配置类mImagesPath==" + mImagesPath + "/n");
        super.addResourceHandlers(registry);
    }

}
