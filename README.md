[toc]
# thymeleaf ��Ŀ
Thymeleaf�ĳ����飺  
  
1������ Thymeleaf ���Ȳ����Ƿ���Ч����������� css/js �ļ��Ƿ���Ч  
  
2�����Թ��ܣ���1������ʾ ת��ͷ�ת��� html �ı� 	��2������ʾ�����Լ���������  ��3����*{}��ʽ��ʾ����  ��4������������  ��5����������һ��ҳ�����Ϣ  
  
3�����Թ��ܣ������ж�  
  
4�����Թ��ܣ���������������1������ͨ����   ��2������״̬�ı���   ��3�������������    ��4������ϵ�ѡ��  
  
# people ��Ŀ
Thymeleaf��ʵս�� 
  
1��������  
listStaff.html�� th:href="@{/deleteStaff(id=${staff.id})}" ��
  
2������ɾ��  
listStaff.html�� onclick="return del()" th:href="@{/deleteStaff(id=${staff.id})}" ��  
  
3����ӡSessionֵ  
listStaff.html�� th:text="${session.editMess}" ��  
  
3��