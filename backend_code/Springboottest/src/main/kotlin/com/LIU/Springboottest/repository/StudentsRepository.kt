package com.LIU.Springboottest.repository

import com.LIU.Springboottest.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentsRepository : JpaRepository<Student, Int>{

}
