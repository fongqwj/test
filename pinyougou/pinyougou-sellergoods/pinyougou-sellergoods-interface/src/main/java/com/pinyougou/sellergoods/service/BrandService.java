package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.service.BaseService;

import java.util.List;

public interface BrandService extends BaseService<TbBrand> {
    //查询品牌
    List<TbBrand> queryAll();

    /**
     * 返回带分页的数据
     * @return List<TbBrand>
     */
    List<TbBrand> testPage(Integer page,Integer rows);
}
