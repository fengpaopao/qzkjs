package com.qzsq.article.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @Author ffc
 * @Description //消息队列
 * @Date 2019/5/9
 * @Param * @param null
 * @return
 **/
@Configuration
public class QueueConfig {
    @Value("${queue}")
    private String queue;

    @Bean
    public Queue logQueue() {
        return new ActiveMQQueue(queue);
    }


}
