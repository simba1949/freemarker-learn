package vip.openpark.operation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.openpark.operation.domain.SearchValDomain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author anthony
 * @version 2024/3/22 9:10
 */
@Controller
@RequestMapping("expression")
public class ExpressionController {

    @GetMapping("searchVal")
    public String searchVal(Model model) {
        // 直接取值
        model.addAttribute("permission", true);

        // Hash
        HashMap<String, Object> bookMap = new HashMap<>();
        bookMap.put("name", "《将进酒》");
        bookMap.put("price", BigDecimal.TEN);

        HashMap<String, Object> authorMap = new HashMap<>();
        authorMap.put("name", "李白");
        authorMap.put("sex", (byte) 1);
        authorMap.put("birthday", LocalDateTime.now());
        bookMap.put("author", authorMap);

        model.addAttribute("book", bookMap);
        // 序列
        List<SearchValDomain> domainList =
            Stream.iterate(1, i -> i + 1)
                .limit(10)
                .map(index -> SearchValDomain.builder().name("李白" + index).sex((byte) 1).birthday(LocalDateTime.now()).build())
                .toList();
        model.addAttribute("dataList", domainList);

        // 对象
        SearchValDomain searchValDomain = SearchValDomain.builder().name("杜甫").sex((byte) 1).birthday(LocalDateTime.now()).build();
        model.addAttribute("person", searchValDomain);

        return "expression/searchVal";
    }

    @GetMapping("sequence")
    public String sequence(Model model) {
        return "expression/sequence";
    }

    @GetMapping("ranges")
    public String ranges(Model model) {
        return "expression/ranges";
    }

    @GetMapping("hash")
    public String hash(Model model) {
        return "expression/hash";
    }
}