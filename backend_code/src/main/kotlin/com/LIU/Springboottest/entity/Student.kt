package com.LIU.Springboottest.entity

import java.time.temporal.TemporalQueries.localDate
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "STUDENTS")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int = 0,
    var name: String = "",
    var status: String = "",
    @Column(name = "CLASS_TEACHER")
    var classTeacher: String = "",
    var note: String = "",
    var birthday: Date = Date(),
    var phone: String = "",
    var qq: String = "",
    @Column(name = "ENTRY_DATE")
    var entryDate: Date = Date(),
    @Column(name = "GRADUATE_DATE")
    var graduateDate: Date = Date(),
    @Column(name = "GRADUATE_SCHOOL")
    var graduateSchool: String = "",
    var major: String = "",
    var japanese: String = "",
    var english: String = ""
)
