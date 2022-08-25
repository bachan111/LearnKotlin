package com.bachan.learnkotlin.test

import kotlin.math.max

class Main {
    val a = 0;//常量
    var b = 0;//变量

    fun fun1(param1: Int, param2: Int): Int {
        return max(param1, param2);
    }

    fun fun2(param1: Int, param2: Int) = max(param1, param2)

    //kotlin的if语句比java多了一个额外功能，可以有返回值
    fun fun3(param1: Int, param2: Int): Int {
        return if (param1 > param2) {
            param1
        } else {
            param2
        }
    }

    fun fun4(param1: Int, param2: Int) = if (param1 > param2) {
        param1
    } else {
        param2
    }

    fun getScore(name: String) = when (name) {
        "TOM" -> 22
        "JSON" -> 33
        else -> 0
    }

    //is = instanceof
    fun checkNum(num: Number) {
        when (num) {
            is Int -> print("int")
            is Double -> print("double")
        }
    }

    //0到10闭区间
    fun fun4() {
        for (i in 0..10) {
            print(i)
        }
    }

    //0到10的左闭右开区间，step跳过区间元素。每次循环增加2，类似java的for-i循环的 i = i+2
    fun fun5() {
        for (i in 0 until 10 step 2) {//升序
            print(i)
        }
        for (i in 10 downTo 1) {//左闭右闭的区间
            print(i)
        }
    }

    fun fun6() {
        val person = Person("JSON", 22)
        person.age = 21
        person.name = "Jone"
        person.eat()

        val student = Student("", 22)
        doStudy(student)
    }

    private fun doStudy(study: IStudy) {
        study.doHomework()
        study.readBook()
    }

}