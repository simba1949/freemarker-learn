package top.simba1949.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/14 16:09
 */
@Controller
@RequestMapping("hello")
public class HelloWorld {

    @GetMapping
    public String helloWorld(){
        System.out.println("Hello World");
        return "HelloWorld";
    }
}
