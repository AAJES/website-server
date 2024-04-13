package com.ajes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ajes.model.Demo;
import com.ajes.service.DemoService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/ajes")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @PostMapping("/demo")
    public Demo addDemo(@RequestBody() Demo demo){

        return demoService.addDemo(demo);
    }

    @GetMapping("/demo/")
    public List<Demo> getAllDemo(){
        return demoService.getAllDemo();
    }

    @GetMapping("/demo/{demoId}")
    public Demo getById(@PathVariable() Integer demoId)
    {
        return demoService.getDemoById(demoId);
    }

    @DeleteMapping("/demo/{demoId}")
    public Demo deleteById(@PathVariable() Integer demoId){
        return demoService.deleteDemoById(demoId);
    }

    @PutMapping("/demo/{demoId}")
    public Demo updateById(@RequestBody() Demo demo,@PathVariable() Integer demoId){
        return demoService.updateDemoById(demoId,demo);
    }

}
