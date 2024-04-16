package org.example.springboot11r2dbc;


import io.r2dbc.spi.ConnectionFactory;
import org.example.springboot11r2dbc.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * spring提供了丰富的映射支持MappingR2dbcConverter。
 * MappingR2dbcConverter具有丰富的元数据模型，允许将域对象映射到数据行。
 * 映射元数据模型是通过在域对象上使用注释来填充的。然而，基础设施并不限于使用注释作为元数据信息的唯一来源。
 * 它还MappingR2dbcConverter允许您通过遵循一组约定将对象映射到行，而无需提供任何其他元数据。
 *
 * MappingR2dbcConverter当没有提供额外的映射元数据时，有一些将对象映射到行的约定。
 * 约定是：
 * 1.短 Java 类名按以下方式映射到表名。
 *      类com.bigbank.SavingsAccount映射到SAVINGS_ACCOUNT表名。
 *      相同的名称映射应用于将字段映射到列名称。
 *      例如，firstName字段映射到FIRST_NAME列。
 *      您可以通过提供自定义NamingStrategy.有关更多详细信息，请参阅映射配置。
 *      默认情况下，在 SQL 语句中使用从属性或类名称派生的表名和列名时不带引号。
 *      您可以通过设置来控制此行为RelationalMappingContext.setForceQuote(true)。
 * 2.不支持嵌套对象。
 * 3.若有转换器, 使用注册的任何 Spring 转换器CustomConversions来覆盖对象属性到行列和值的默认映射。
 * 4.对象的字段用于在行中的列之间进行转换。JavaBean不使用公共属性。
 * 5.如果您有一个非零参数构造函数，其构造函数参数名称与行的顶级列名称匹配，则使用该构造函数。否则，使用零参数构造函数。如果有多个非零参数构造函数，则会引发异常。
 *
 *
 *
 *
 *
 * @author booty
 */
@SpringBootTest
public class T03MappingTest {

    @Autowired
    R2dbcEntityTemplate template;
    @Autowired
    ConnectionFactory connectionFactory;


    @Test
    void  mappingTest() throws Exception{
       // select a.*,c.id c_id,c.name c_name,c.age c_age,c.version c_version from person a where a.id=?id or a.name=?name left join person c where c.id=1
        template.select(Person.class)
                .all()
                .subscribe(System.out::println)
        ;
        TimeUnit.SECONDS.sleep(5);
    }





}
