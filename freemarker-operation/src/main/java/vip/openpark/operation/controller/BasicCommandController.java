package vip.openpark.operation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.openpark.operation.domain.Person;
import vip.openpark.operation.domain.SearchValDomain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

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
        Person person = Person.builder().name("李白").sex((byte) 1).birthday(LocalDateTime.now()).build();
        model.addAttribute("val", 1);
        model.addAttribute("person", person);
        return "basicCommand/ifCommand";
    }

    @GetMapping("list")
    public String listCommand(Model model) {
        // 序列
        List<SearchValDomain> domainList =
            Stream.iterate(1, i -> i + 1)
                .limit(10)
                .map(index -> SearchValDomain.builder().name("李白" + index).sex((byte) 1).birthday(LocalDateTime.now()).build())
                .toList();
        model.addAttribute("dataList", domainList);
        return "basicCommand/listCommand";
    }

    @GetMapping("include")
    public String includeCommand(Model model) {
        return "basicCommand/include/main";
    }

    @GetMapping("sep")
    public String sepCommand(Model model) {
        // 序列
        List<Integer> domainList =
            Stream.iterate(1, i -> i + 1)
                .limit(10)
                .toList();
        model.addAttribute("dataList", domainList);
        return "basicCommand/sepCommand";
    }

    @GetMapping("break")
    public String breakCommand(Model model) {
        // 序列
        List<Integer> domainList =
            Stream.iterate(1, i -> i + 1)
                .limit(10)
                .toList();
        model.addAttribute("dataList", domainList);
        return "basicCommand/breakCommand";
    }
}