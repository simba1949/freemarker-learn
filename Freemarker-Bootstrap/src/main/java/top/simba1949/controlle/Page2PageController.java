package top.simba1949.controlle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/15 9:52
 */
@RequestMapping
@Controller
public class Page2PageController {

    @RequestMapping
    public String index(){
        return "Index";
    }

    @RequestMapping("page")
    public String page(){
        return "Page";
    }

    @RequestMapping("BootstrapLocal")
    public String bootstrapLocal(){
        return "BootstrapLocal";
    }
}
