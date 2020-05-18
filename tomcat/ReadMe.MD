#tomcat 镜像制作

wget https://mirrors.tuna.tsinghua.edu.cn/apache/tomcat/tomcat-8/v8.5.55/bin/apache-tomcat-8.5.55.tar.gz

# 制作镜像
docker build -t tomcat8:latest .
# 启动容器
docker run -itd -p 8080:8080 tomcat8 /bin/bash

参考：
https://www.jianshu.com/p/1cd3ff442385
https://www.cnblogs.com/linjiqin/p/9402350.html