package com.matigou.core;

import com.alibaba.cloud.nacos.registry.NacosAutoServiceRegistration;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.Query;
import java.lang.management.ManagementFactory;
import java.util.Set;

@Component
public class NacosConfig implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(NacosConfig.class);

    @Resource
    private NacosAutoServiceRegistration registration;

    @Value("${server.port:8080}")
    Integer port;

    @Override
    public void run(ApplicationArguments args) {
        Integer tomcatPort = port;
        if (registration != null && port != null) {
            try {
                tomcatPort = new Integer(getTomcatPort());
            } catch (Exception e) {
                e.printStackTrace();
            }

            registration.setPort(tomcatPort);
            registration.start();
        }
        LOGGER.info("server.port: {}", tomcatPort);
    }

    /**
     * 获取外部tomcat端口
     */
    public String getTomcatPort() throws Exception {
        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
        Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"), Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
        String port = objectNames.iterator().next().getKeyProperty("port");
        return port;
    }
}