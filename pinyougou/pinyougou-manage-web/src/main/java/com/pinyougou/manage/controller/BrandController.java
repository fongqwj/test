package com.pinyougou.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/brand")
//@Controller
@RestController //组合注解:包括了Controller  ResponseBody两个注解:对该类的所有方法生效
public class BrandController {

    /**
     * 从注册中心获取该对象:在配置文件中已经指定了注册中心
     */
    @Reference
    //@Autowired
    private BrandService brandService;

    @GetMapping("/findAll")
//    @ResponseBody
//    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<TbBrand> findAll(){
//        return brandService.queryAll();
        return brandService.findAll();
    }

    /**
     *  http://localhost:9100/brand/testPage.do?page=1&rows=5
     *  分页查询
     */
    @GetMapping("/testPage")
    public List<TbBrand> testPage(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                  @RequestParam(value = "rows",defaultValue = "5")Integer rows){
//        return brandService.testPage(page,rows);
        return (List<TbBrand>) brandService.findPage(page,rows).getRows();
    }
}
