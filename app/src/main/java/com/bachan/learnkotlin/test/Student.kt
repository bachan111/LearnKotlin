package com.bachan.learnkotlin.test

class Student(val sno: String, val grade: Int, name:String,age:Int) : Person(name,age), IStudy {
    init {
        print(sno + grade)
    }

    //当一个类既有主构造函数，又有次构造函数，所有的次构造函数必须调用主构造函数
    constructor(name: String,age: Int):this("",0,"",0){}

    override fun readBook() {
        TODO("Not yet implemented")
    }

    override fun doHomework() {
        TODO("Not yet implemented")
    }
}