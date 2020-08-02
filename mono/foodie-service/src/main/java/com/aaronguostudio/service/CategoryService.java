package com.aaronguostudio.service;

import com.aaronguostudio.pojo.Category;
import com.aaronguostudio.pojo.vo.CategoryVO;

import java.util.List;

public interface CategoryService {

    public List<Category> queryAllRootLevelCat();

    public List<CategoryVO> getSubCatList(Integer rootCatId);
}
