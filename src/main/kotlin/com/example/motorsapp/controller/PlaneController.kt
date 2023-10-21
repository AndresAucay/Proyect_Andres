package com.example.motorsapp.controller

import com.example.motorsapp.model.Plane
import com.example.motorsapp.service.PlaneService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/plane")   //endpoint

class PlaneController {
    @Autowired
    lateinit var planeService: PlaneService

    @GetMapping
    fun list ():List <Plane>{
        return planeService.list()
    }
    @PostMapping
    fun save (@RequestBody plane:Plane):ResponseEntity<Plane>{
        return ResponseEntity(planeService.save(plane), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody plane:Plane):ResponseEntity<Plane>{
        return ResponseEntity(planeService.update(plane), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody plane: Plane):ResponseEntity<Plane>{
        return ResponseEntity(planeService.updateTotal(plane), HttpStatus.OK)
    }
}