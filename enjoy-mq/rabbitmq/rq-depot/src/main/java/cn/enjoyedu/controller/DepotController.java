package cn.enjoyedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author marvin
 * <p>
 * 类说明：
 */
@Controller
public class DepotController {

    @RequestMapping("/depotIndex")
    public String userReg() {
        return "index";
    }
}
