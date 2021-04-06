### 功能
日志打印，操作记录

1. `@SysLog` 注解在Controller类实现该Controller下所有请求日志打印
2. `@SysLog` 注解在Controller类下的请求方法，实现该操作的记录(数据库)


### 集成步骤
1. 创建数据表
2. 引入jar包
   ```
   <dependency>
      <groupId>com.springboot</groupId>
      <artifactId>spring-boot-starter-logging</artifactId>
      <version>1.0.0</version>
   </dependency>
   ```
3. Mysql,Mybatis配置
   ```
   spring:
      datasource:
      url: jdbc:mysql://localhost:3306/database?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&useSSL=true
      username: root
      password: root
      driver-class-name: com.mysql.cj.jdbc.Driver
      
   mybatis:
      configuration:
      log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
      mapper-locations: classpath*:mapper/*.xml
   ```
   Main
   ```
   @MapperScan("com.springboot.logging.dao")
   ```
4. SecurityConfig配置
   
   这里有两种集成方式可供选择:
   
   1. 禁用Security
      ```
       # security disable
       spring:
           autoconfigure:
               exclude: org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
      ```
   2. 配置Security,详情见Spring Security配置
   

