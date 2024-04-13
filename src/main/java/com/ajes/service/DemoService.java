package com.ajes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajes.model.Demo;
import com.ajes.repository.DemoRepository;
@Service

public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    public Demo addDemo(Demo demo){
        return demoRepository.save(demo);
    }

    public List<Demo> getAllDemo(){
        return demoRepository.findAll();
    }

    public Demo getDemoById(Integer demoId){
        return demoRepository.findById(demoId).get();
    }

    public Demo deleteDemoById(Integer demoId){
        Demo demo = getDemoById(demoId);
        demoRepository.deleteById(demoId);
        return demo;
    }

    public Demo updateDemoById(Integer demoId,Demo demo){
        return demoRepository.save(demo);
    }
}
