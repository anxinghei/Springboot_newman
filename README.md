[toc]
# thymeleaf 项目
Thymeleaf的初体验：  
  
1、测试 Thymeleaf 和热部署是否生效  

2、测试引入的 css/js 文件是否生效  
  
3、测试功能：（1）、显示 转义和非转义的 html 文本 	（2）、显示对象以及对象属性  （3）、*{}方式显示属性  （4）、算数运算  （5）、引用另一个HTML的页面  
  
4、测试功能：条件判断（布尔值）  
    
5、测试功能：遍历————（1）、普通遍历   （2）、带状态的遍历   （3）、结合下拉框    （4）、结合单选框  
  
# people 项目
Thymeleaf的实战： 
  
1、超链接  
listStaff.html【 th:href="@{/deleteStaff(id=${staff.id})}" 】
  
2、单个删除  
listStaff.html【 onclick="return del()" th:href="@{/deleteStaff(id=${staff.id})}" 】  
  
3、打印Session值  
listStaff.html【 th:text="${session.editMess}" 】  
  
4、id（数字）判断  
page.html【th:if="${manager.id > 1}"】  
  
5、
