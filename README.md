项目是一个简单的照片管理网站，现在实现的功能有照片的上传、修改和删除（包括批量删除）
项目主要使用了基于Spinrg+SpringMvc+Mybatis+Bootstrap。使用Spinrg+SpringMvc+Mybatis来搭建服务器端，使用Bootstrap来搭建前端页面。
项目的Java版本是1.8.0_162版本，使用了eclipse进行开发。

页面的相关截图：
![Image text](https://github.com/dengqi1999/photomanage/blob/master/img/photo1.PNG)
![Image text](https://github.com/dengqi1999/photomanage/blob/master/img/photo2.PNG)
![Image text](https://github.com/dengqi1999/photomanage/blob/master/img/photo3.PNG)
![Image text](https://github.com/dengqi1999/photomanage/blob/master/img/photo4.PNG)
![Image text](https://github.com/dengqi1999/photomanage/blob/master/img/photo5.PNG)

<b>数据库表结构：</b>
![Image text](https://github.com/dengqi1999/photomanage/blob/master/img/database.PNG)
表中有六项，分别是
photoid（服务器生成的唯一的id，使用java.util.UUID生成）
photoname（用户命名的图片名字）
gname（分组名称，分组展示功能暂时未实现）
realpath（在服务端实际储存的位置）
path（图片的网络访问位置）
size（图片大小）

<b>bean、dao层以及mapper的生成：</b></br>
项目使用了Mybatis的逆向工程，需要引入相关的jar包，以及对应的配置，配置文件为mbg.xml，运行的test文件在com.dq.photomanegement.test包中。
如果不了解，可以去http://mybatis.org/generator/ 详细了解具体的使用方法

<b>图片上传实现：</b></br>
图片的上传使用了springmvc提供的文件解析组件org.springframework.web.multipart.commons.CommonsMultipartResolver,配置在dispacherServlet-servlet.xml中。
如果想要使用更多的方法上传图片，可以参考博客：https://blog.csdn.net/weixin_43464964/article/details/86532616 。

<b>前端页面的实现：</b></br>
前端页面的搭建使用了bootstrap框架来快速搭建，如果想要重新搭建，可以参考bootstrap的官方文挡：https://v3.bootcss.com/



