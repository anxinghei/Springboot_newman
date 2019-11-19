package com.example.demo.Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.User;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Controller
public class HtmlGetting {

	//localhost:8080/freemarker/exportHtml
		@RequestMapping("exportHtml")
		@ResponseBody
		public String html() throws TemplateException, IOException {
			  // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。  
	        Configuration configuration = new Configuration(Configuration.getVersion());  
	        // 第二步：设置模板文件所在的路径。  
	        configuration.setDirectoryForTemplateLoading(new File("D:\\E_softwareFiles\\Eclipse\\freemarker\\src\\main\\resources\\template"));  
	        // 第三步：设置模板文件使用的字符集。一般就是utf-8.  
	        configuration.setDefaultEncoding("utf-8");  
	        // 第四步：加载一个模板，创建一个模板对象。  
	        Template template = configuration.getTemplate("DownLoading.ftl");  
	        // 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。  
	        Map dataModel = new HashMap<>();  
	        //向数据集中添加数据  
	        List<User> users=initList();
	        dataModel.put("userList",users);  
	        // 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。  
	        Writer out = new FileWriter(new File("D:\\E_softwareFiles\\Eclipse\\freemarker\\src\\main\\resources\\templates\\DownLoading.html"));  
	        // 第七步：调用模板对象的process方法输出文件。  
	        template.process(dataModel, out);  
	        // 第八步：关闭流。  
	        out.close();  
			return "Get";
		}
		
		public List<User> initList(){
			List<User> users=new ArrayList<User>();
			users.add(new User("张三", "890123", 18));
			users.add(new User("李四", "901234", 23));
			users.add(new User("王五", "012345", 14));
			users.add(new User("赵六", "123456", 30));
			users.add(new User("田七", "234567", 32));
			return users;
		}
}
