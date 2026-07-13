package com.backend.controllers;

import com.backend.entity.SystemHealth;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/health")
public class Health {

    SystemHealth systemHealth = new SystemHealth("Joao", "Maria auxiliadora");

    @GetMapping("/health")
    public String getHealth(SystemHealth systemHealth){
        return systemHealth.getName() + systemHealth.getHospital();
    }

    @PostMapping("/health")
    public void postHealth(String name, String hospital){
        SystemHealth systemHealth1 = new SystemHealth(name, hospital);
    }

    @PatchMapping("/health")
    public void postHealth(SystemHealth systemHealth, String name, String hospital){
        systemHealth.setName(name);
        systemHealth.setHospital(hospital);
    }

}
