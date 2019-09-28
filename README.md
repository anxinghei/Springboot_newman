[toc]
# thymeleaf 项目
Thymeleaf的初体验：  
  
1、测试 Thymeleaf 和热部署是否生效  

2、测试引入的 css/js 文件是否生效  
  
3、测试功能：（1）、显示 转义和非转义的 html 文本 	（2）、显示对象以及对象属性  （3）、*{}方式显示属性  （4）、算数运算  （5）、引用另一个HTML的页面  
  
4、测试功能：条件判断（布尔值）  
    
5、测试功能：遍历————（1）、普通遍历   （2）、带状态的遍历   （3）、结合下拉框    （4）、结合单选框 
 
6、多选框CheckBox 
<input type="checkbox" th:each="rule:${firstRule}" th:value="${rule.id}"  th:text="${rule.title}" th:attr="checked=${rule.checked}" / >
  
# people 项目
Thymeleaf实战（简单的人事管理系统）： 
  
1、超链接（无参，有参看下一点）  
listStaff.html【th:href="@{/toAddStaff}"】
  
2、按钮功能：确认删除  
listStaff.html【onclick="return del()" th:href="@{/deleteStaff(id=${staff.id})}"】  
  
3、打印Session值  
listStaff.html【th:text="${session.editMess}"】  
  
4、id（数字）判断  
page.html【th:if="${manager.id > 1}"】  
  
5、历史回退  
page.html【onClick="javascript:history.back()"】  
  
6、表单动作  
editStaff.html【th:action="@{/updateStaff}" method="post"】  
  
7、输入项默认值  
editStaff.html【type="text" th:value="${staff_edit.name}】  
  
# security 项目  
Spring Security 安全设置：  
  
1、角色有默认前缀：ROLE_ ，没有添加则权限不足，访问403  
  
2、使用Thymeleaf，继承WebMvcConfigureAdapter重写addViewControllers方法  
【registry.addViewController("/hello").setViewName("home")】  
方可访问/hello请求跳转到home.html页面而不是404  
  
3、Excel 文件的导入导出（简单实现） 
 
# shiro 项目  
 
1、来源：哔哩哔哩
