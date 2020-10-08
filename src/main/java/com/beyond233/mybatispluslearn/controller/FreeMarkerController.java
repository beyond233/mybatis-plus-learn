package com.beyond233.mybatispluslearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-06-04 16:46
 */
@Controller
@RequestMapping("/page")
public class FreeMarkerController {
    @GetMapping("/index")
    public String indexPage(ModelMap modelMap){
        modelMap.addAttribute("var","FreeMarker!");
        return "index";
    }

}
