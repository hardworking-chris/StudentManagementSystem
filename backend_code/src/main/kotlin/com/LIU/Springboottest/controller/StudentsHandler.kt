package com.LIU.Springboottest.controller

import com.LIU.Springboottest.entity.Student
import com.LIU.Springboottest.repository.StudentsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class StudentsHandler {
    @Autowired
    lateinit var studentsRepository: StudentsRepository

    @GetMapping("/findAll/{page}/{size}")
    fun findAll(@PathVariable("page") page:Int, @PathVariable ("size") size:Int) : Page<Student> {
        val pageable : PageRequest = PageRequest.of(page-1,size)
        return studentsRepository.findAll(pageable)
    }

    @PostMapping("/save")
    fun save(@RequestBody student: Student): String {
        val result:Student = studentsRepository.save(student)
        return "success"
    }

    @GetMapping("/findById/{id}")
    fun findById(@PathVariable("id") id:Int) : Student{
        return studentsRepository.findById(id).get()
    }

    @PutMapping("/update")
    fun update(@RequestBody student: Student): String {
        studentsRepository.save(student)
        return "success"
    }

    @DeleteMapping("/deleteById/{id}")
    fun deleteById(@PathVariable("id") id:Int) {
        studentsRepository.deleteById(id)
    }

}
