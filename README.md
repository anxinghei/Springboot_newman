[toc]
# thymeleaf ��Ŀ
Thymeleaf�ĳ����飺  
  
1������ Thymeleaf ���Ȳ����Ƿ���Ч  

2����������� css/js �ļ��Ƿ���Ч  
  
3�����Թ��ܣ���1������ʾ ת��ͷ�ת��� html �ı� 	��2������ʾ�����Լ���������  ��3����*{}��ʽ��ʾ����  ��4������������  ��5����������һ��HTML��ҳ��  
  
4�����Թ��ܣ������жϣ�����ֵ��  
    
5�����Թ��ܣ���������������1������ͨ����   ��2������״̬�ı���   ��3�������������    ��4������ϵ�ѡ��  
  
# people ��Ŀ
Thymeleafʵս���򵥵����¹���ϵͳ���� 
  
1�������ӣ��޲Σ��вο���һ�㣩  
listStaff.html��th:href="@{/toAddStaff}"��
  
2����ť���ܣ�ȷ��ɾ��  
listStaff.html��onclick="return del()" th:href="@{/deleteStaff(id=${staff.id})}"��  
  
3����ӡSessionֵ  
listStaff.html��th:text="${session.editMess}"��  
  
4��id�����֣��ж�  
page.html��th:if="${manager.id > 1}"��  
  
5����ʷ����  
page.html��onClick="javascript:history.back()"��  
  
6��������  
editStaff.html��th:action="@{/updateStaff}" method="post"��  
  
7��������Ĭ��ֵ  
editStaff.html��type="text" th:value="${staff_edit.name}��  
  
# security ��Ŀ  
Spring Security ��ȫ���ã�  
  
1����ɫ��Ĭ��ǰ׺��ROLE_ ��û�������Ȩ�޲��㣬����403  
  
2��ʹ��Thymeleaf���̳�WebMvcConfigureAdapter��дaddViewControllers����  
��registry.addViewController("/hello").setViewName("home")��  
���ɷ���/hello������ת��home.htmlҳ�������404  
  
3��Excel �ļ��ĵ��뵼������ʵ�֣� 
 
# shiro ��Ŀ  
 
1����Դ����������