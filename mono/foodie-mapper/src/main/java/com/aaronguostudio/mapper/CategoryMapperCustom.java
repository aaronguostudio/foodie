package com.aaronguostudio.mapper;

import com.aaronguostudio.pojo.vo.CategoryVO;

import java.util.List;

public interface CategoryMapperCustom {

    public List<CategoryVO> getSubCatList(Integer rootCatId);
}