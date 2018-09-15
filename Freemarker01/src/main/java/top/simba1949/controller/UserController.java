package top.simba1949.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.simba1949.common.UserCommon;
import top.simba1949.service.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/14 15:37
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("href")
    public String href0(){
        return "user/01href";
    }

    @RequestMapping("href0")
    public String href(){
        return "user/02href";
    }

    @RequestMapping("if")
    public String getUser(Model model){
        List<UserCommon> list = userService.getUsersNoCondition();

        model.addAttribute("users",list);
        UserCommon common = new UserCommon();
        common.setUsername("李白");
        common.setId(1);
        model.addAttribute("common",common);

        return "user/03if";
    }

    @RequestMapping("list")
    public String list(Model model){
        List<UserCommon> list = userService.getUsersNoCondition();

        model.addAttribute("list",list);
        return "user/04list";
    }

    @RequestMapping("sep")
    public String sep(Model model){
        List<UserCommon> list = userService.getUsersNoCondition();

        model.addAttribute("list",list);
        return "user/05sep";
    }

    @RequestMapping("break")
    public String breakInstruction(Model model){
        List<UserCommon> list = userService.getUsersNoCondition();

        model.addAttribute("list",list);
        return "user/06break";
    }

    @RequestMapping("interpolation")
    public String dateString(Model model){
        // 字符串
        String string = "君不见黄河之水天上来";
        model.addAttribute("string",string);
        // 数字
        Byte byteNumber = 1;
        model.addAttribute("byteNumber",byteNumber);
        Short shortNumber = 1;
        model.addAttribute("shortNumber",shortNumber);
        Integer intNumber = 1;
        model.addAttribute("intNumber",intNumber);
        Long longNumber = 1L;
        model.addAttribute("longNumber",longNumber);
        Float floatNumber = 1.0F;
        model.addAttribute("floatNumber",floatNumber);
        Double doubleNumber = 1.0;
        model.addAttribute("doubleNumber",doubleNumber);

        // 日期
        Date date = new Date();
        model.addAttribute("date",date);

        // 布尔类型
        Boolean booleanTrueType = true;
        model.addAttribute("booleanTrueType",booleanTrueType);
        Boolean booleanFalseType = false;
        model.addAttribute("booleanFalseType",booleanFalseType);

        return "user/07interpolation";
    }

    @RequestMapping("freemarkerList")
    public String freemarkerList(Model model){
        return "user/08list";
    }

    @RequestMapping("numberRange")
    public String numberRange(Model model){
        return "user/09numberRange";
    }

    @RequestMapping("hashMap")
    public String hashMap(Model model){
        return "user/10hashMap";
    }

    @RequestMapping("mathematical")
    public String mathematical(Model model){
        model.addAttribute("five",5);
        model.addAttribute("trueType",true);
        return "user/11mathematical";
    }

}
