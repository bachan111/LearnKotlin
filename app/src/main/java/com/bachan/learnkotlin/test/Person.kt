package com.bachan.learnkotlin.test

open class Person(name: String, age: Int) {
    var name = ""
    var age = 0
    fun eat() {
        print(name + "is " + age + "years old")
    }

}