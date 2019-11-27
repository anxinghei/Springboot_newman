package com.example.demo.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@RestController
public class HtmlGetting {
	
	// localhost:8080/freemarker/absolutePath
	@RequestMapping("absolutePath")
	public String html() throws TemplateException, IOException {
		// 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
		Configuration configuration = new Configuration(Configuration.getVersion());
		// 第二步：设置模板文件所在的路径。
		configuration.setDirectoryForTemplateLoading(new File(
				"D:\\E_softwareFiles\\Eclipse\\Springboot_newman\\freemarker\\src\\main\\resources\\template"));
		// 第三步：设置模板文件使用的字符集。一般就是utf-8.
		configuration.setDefaultEncoding("utf-8");
		// 第四步：加载一个模板，创建一个模板对象。
		Template template = configuration.getTemplate("htmlList.ftl");
		// 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
		Map dataModel = new HashMap<>();
		// 向数据集中添加数据
		List<User> users = User.initList();
		dataModel.put("userList", users);
		// 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
		Writer out = new FileWriter(new File(
				"D:\\E_softwareFiles\\Eclipse\\Springboot_newman\\freemarker\\src\\main\\resources\\templates\\absolutePath.html"));
		// 第七步：调用模板对象的process方法输出文件。
		template.process(dataModel, out);
		// 第八步：关闭流。
		out.close();
		return "Get";
	}

	// localhost:8080/freemarker/classPath
	@RequestMapping("classPath")
	public String testGenerateHtml() throws IOException, TemplateException, URISyntaxException {
		// 创建配置类
		Configuration configuration = new Configuration(Configuration.getVersion());
		// 设置模板路径 toURI()防止路径出现空格
		// /D:/E_softwareFiles/Eclipse/Springboot_newman/freemarker/target/classes/
		String classpath = this.getClass().getResource("/").toURI().getPath();
		System.out.println(classpath);
		configuration.setDirectoryForTemplateLoading(new File(classpath + "/template/"));
		// 设置字符集
		configuration.setDefaultEncoding("utf-8");
		// 加载模板
		Template template = configuration.getTemplate("htmlList.ftl");
		// 数据模型
		Map dataModel = new HashMap<>();
		List<User> users = User.initList();
		dataModel.put("userList", users);
		// 静态化
		String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, dataModel);
		// 打印静态化内容
		System.out.println(content);
		InputStream inputStream = IOUtils.toInputStream(content);
		// 定位到项目路径
		// /D:/E_softwareFiles/Eclipse/Springboot_newman/freemarker
		String path=System.getProperty("user.dir");
		System.out.println(path);
		// 输出文件
		FileOutputStream fileOutputStream = new FileOutputStream(new File(path + "/src/main/resources/templates/classPath.html"));
		int copy = IOUtils.copy(inputStream, fileOutputStream);
		return "It's OK";
	}

}
