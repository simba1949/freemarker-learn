package vip.openpark.operation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.openpark.operation.domain.Person;

import java.time.LocalDateTime;

/**
 * freemarker 基本指令操作
 *
 * @author anthony
 * @version 2024/3/21 21:21
 */
@Controller
@RequestMapping("basicCommand")
public class BasicCommandController {

    /**
     * if 指令
     *
     * @param model model
     * @return 视图
     */
    @GetMapping("if")
    public String ifCommand(Model model) {
        Person person = Person.builder().id(1L).name("李白").age(18).sex((byte) 1).birthday(LocalDateTime.now()).build();
        model.addAttribute("val", 1);
        model.addAttribute("person", person);
        return "basicCommand/ifCommand";
    }
}