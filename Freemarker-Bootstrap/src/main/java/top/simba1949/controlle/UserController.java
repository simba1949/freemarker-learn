package top.simba1949.controlle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/15 9:42
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("userss")
    public String getUsers(){
        return null;
    }
}
