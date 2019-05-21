[toc]
# thymeleaf 项目
Thymeleaf的初体验：  

1、测试 Thymeleaf 和热部署是否生效；测试引入的 css/js 文件是否生效  

2、测试功能：（1）、显示 转义和非转义的 html 文本 	（2）、显示对象以及对象属性  （3）、*{}方式显示属性  （4）、算数运算  （5）、包含另一个页面的信息  

3、测试功能：条件判断  

4、测试功能：遍历————（1）、普通遍历   （2）、带状态的遍历   （3）、结合下拉框    （4）、结合单选框  
# people 项目
Thymeleaf的实践：  

1、单个删除  
listStaff.html【 onclick="return del()" th:href="@{/deleteStaff(id=${staff.id})}" 】    

2、打印Session值  
listStaff.html【 th:text="${session.editMess}" 】  
  
3、  

