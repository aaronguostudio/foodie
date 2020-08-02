package com.aaronguostudio.service;

import com.aaronguostudio.pojo.Carousel;

import java.util.List;

public interface CarouselService {
    public List<Carousel> queryAll(Integer isShow);
}
