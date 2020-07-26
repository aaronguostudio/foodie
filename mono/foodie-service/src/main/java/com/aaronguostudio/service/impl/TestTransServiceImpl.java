package com.aaronguostudio.service.impl;

import com.aaronguostudio.service.StuService;
import com.aaronguostudio.service.TestTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestTransServiceImpl implements TestTransService {

    /*
    * Transaction Propagation
    *   Required
    *   SUPPORTS
    *   MANDATORY
    *   NOT_SUPPORTED
    *   NEVER
    *   NESTED
    * */

    @Autowired
    private StuServiceImpl stuService;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testPropagationTrans() {
        stuService.saveParent();
        stuService.saveChildren();
        int a = 1 / 0;
    }
}
