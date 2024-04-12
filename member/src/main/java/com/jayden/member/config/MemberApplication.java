package com.jayden.member.config;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

/**
 * @author 12633
 */
@SpringBootApplication
@ComponentScan("com.jayden")
@MapperScan("com.jayden.member.mapper")
public class MemberApplication {

    private static final Logger LOG = LoggerFactory.getLogger(MemberApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MemberApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("地址：http://127.0.0.1:{}{}/test",env.getProperty("server.port"),env.getProperty("server.servlet.context-path"));
        // note：这里还可以打印项目的 LOGO、接口文档、项目说明书的地址等等
    }
}
