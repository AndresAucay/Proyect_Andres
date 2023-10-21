package com.example.motorsapp.service

import com.example.motorsapp.model.Plane
import com.example.motorsapp.repository.PlaneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PlaneService {
    @Autowired
    lateinit var planeRepository: PlaneRepository

    fun list ():List<Plane>{
        return planeRepository.findAll()
    }
    fun save(plane: Plane): Plane{
        try{
            return planeRepository.save(plane)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(plane:Plane): Plane{
        try {
            planeRepository.findById(plane.id)
                    ?: throw Exception("ID no existe")

            return planeRepository.save(plane)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(plane: Plane): Plane{
        try{
            val response = planeRepository.findById(plane.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                fullname=plane.fullname //un atributo del modelo
            }
            return planeRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}
