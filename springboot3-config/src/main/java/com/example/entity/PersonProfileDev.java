package com.example.entity;

//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author booty
 */
@Component
@ConfigurationProperties(prefix = "person-dev") //和配置文件person前缀的所有配置进行绑定
@Data
@Profile("dev") // 使用该注解后, 在指定的环境下才会注入改bean
public class PersonProfileDev {
    private String name;
//    private Integer age;
//    private Date birthDay;
//    private Boolean like;
//    private Child child; //嵌套对象
//    private List<Dog> dogs; //数组（里面是对象）
//    private Map<String,Cat> cats; //表示Map
}

