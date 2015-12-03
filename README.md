# RESTful-service
### Build a RESTful-servcie framework project which based java language.
************************************************************************
### Framework content：
* Based MAVEN + SPRING + SPRING-MVC + MYBATIS
 * MAVEN : Muti-environment profiles, tomcat7-plugin.
 * SPRING : Jackson, aspectj, spirng-test, spring-tx.
 * MYBATIS : mybatis-generator, pagehelper.
 * OTHERS : log4j, hibernate-validator.
* 优化简化代码开发流程，提供代码生成工具，封装全局异常处理，返回处理等，尽量减少代码开发难度，让开发人员专注于业务；
* 测试，基于junit4+spring-test， 简化测试开发；
* 安全:
 * 完善的权限控制，使用自定义的拦截器来决定权限规则；
 * 全局事务支持，基于AOP切面编程，统一事务处理，保证数据一致性安全；
 * （规划）后台数据校验，基于JSR-349校验规则，由spring+hibernate-validator实现；
* 代码规范，编码规范；

-----------------------------------
2015.12.3
@author Alan Zhang
***********************************
* new
 * Build this text file.
