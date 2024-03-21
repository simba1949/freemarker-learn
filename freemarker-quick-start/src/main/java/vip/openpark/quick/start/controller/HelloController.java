package vip.openpark.quick.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author anthony
 * @version 2024/3/21 20:46
 */
@Controller
public class HelloController {
    @GetMapping("hello")
    public String helloWorld(Model model) {
        model.addAttribute("data", "Hello FreeMarker!");
        model.addAttribute("indexName", "自定义首页标题");
        // 返回模板
        // 需要结合 application.properties 配置文件中的 freemarker 前缀后缀配置
        // 即：spring.freemarker.prefix/spring.freemarker.suffix
        return "hello";
    }
}