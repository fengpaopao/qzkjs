package com.qzsq.article.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


@Component
public class Config {

    public static final Properties config = new Properties();

    static {
        InputStream is = Config.class.getClassLoader().getResourceAsStream("qzkj-article.properties");

        try {
            config.load(is);
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
