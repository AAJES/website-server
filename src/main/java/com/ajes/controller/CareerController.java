package com.ajes.controller;

import com.ajes.model.Career;
import com.ajes.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajes")
@CrossOrigin("http://localhost:4200")
public class CareerController {

    @Autowired
    private CareerService careerService;

    @PostMapping("/careers")
    public Career addCareer(@RequestBody() Career career){
        return careerService.addCareer(career);
    }

    @GetMapping("/careers/")
    public List<Career> getAllCareer(){
        return careerService.getAllCareer();
    }

    @GetMapping("/careers/{careerId}")
    public Career getById(@PathVariable() Integer careerId){
        return careerService.getCareerById(careerId);
    }

    @PutMapping("/career/{careerId}")
    public Career deleteByID(@RequestBody() Career career, @PathVariable() Integer careerId){
        return careerService.updateCareerById(careerId,career);
    }
}


