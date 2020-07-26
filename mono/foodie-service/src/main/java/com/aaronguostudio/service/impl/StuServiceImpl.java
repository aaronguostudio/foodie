package com.aaronguostudio.service.impl;

import com.aaronguostudio.mapper.StuMapper;
import com.aaronguostudio.pojo.Stu;
import com.aaronguostudio.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Stu getStuInfo(int id) {

        return stuMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveStu() {
        Stu stu = new Stu();
        stu.setName("Aaron");
        stu.setAge(33);
        stuMapper.insert(stu);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateStu(int id) {
        Stu stu = new Stu();
        stu.setId(id);
        stu.setName("Lucy");
        stu.setAge(22);
        stuMapper.updateByPrimaryKey(stu);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteStu(int id) {
        stuMapper.deleteByPrimaryKey(id);
    }

    public void saveParent() {
        Stu stu = new Stu();
        stu.setName("A is Parent");
        stu.setAge(19);
        stuMapper.insert(stu);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveChildren() {
        saveChild1();
        saveChild2();
    }

    public void saveChild1() {
        Stu stu = new Stu();
        stu.setName("A is Child - 1");
        stu.setAge(19);
        stuMapper.insert(stu);
    }

    public void saveChild2() {
        Stu stu = new Stu();
        stu.setName("A is Child - 2");
        stu.setAge(16);
        stuMapper.insert(stu);
    }
}
