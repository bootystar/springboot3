package com.example.service;

import com.example.event.LoginEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author booty
 */
@Service
@Slf4j
@Order(3) // 使用order注解可以指定事件订阅接收的优先级
public class ScoreServiceByImpl implements ApplicationListener<LoginEvent> {


    @Override
    public void onApplicationEvent(LoginEvent event) {
          log.info("积分服务(接口实现)感知到登录事件,为用户增加积分"+event.getSource());
    }
}
