package com.aaronguostudio.controller;

import com.aaronguostudio.enums.YesOrNo;
import com.aaronguostudio.pojo.Carousel;
import com.aaronguostudio.pojo.Category;
import com.aaronguostudio.pojo.vo.CategoryVO;
import com.aaronguostudio.service.CarouselService;
import com.aaronguostudio.service.CategoryService;
import com.aaronguostudio.utils.IMOOCJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/carousel")
    public IMOOCJSONResult carousel() {
        List<Carousel> list = carouselService.queryAll(YesOrNo.YES.type);
        return IMOOCJSONResult.ok(list);
    }

    @GetMapping("/cats")
    public IMOOCJSONResult cats() {
        List<Category> cats = categoryService.queryAllRootLevelCat();
        return IMOOCJSONResult.ok(cats);
    }

    @GetMapping("/subCat/{rootCatId}")
    public IMOOCJSONResult subCat(
        @PathVariable Integer rootCatId
    ) {
        if (rootCatId == null) {
            return IMOOCJSONResult.errorMsg("分类不存在");
        }

        List<CategoryVO> result = categoryService.getSubCatList(rootCatId);
        return IMOOCJSONResult.ok(result);
    }
}
