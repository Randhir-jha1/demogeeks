package com.demo.demogeeks


//Example public ,protected,private;
// Abstraction:
abstract class Employee(val name:String, val experience:Int){

    abstract var salary:Double
    abstract fun dob(date:String)
    fun employeeDetails(){
        println("Name: $name")
        println("Experience: $experience")
    }
}

class Engineer(name: String,experience: Int):Employee(name, experience) {
    override var salary = 5000.00


    override fun dob(date: String) {
         println("Dob $date")
    }
}
// Overloading & Overriding

class MathOpertion{
    fun add(a:Int,b:Int):Int{
        return a+b
    }
    fun add(a:Double,b:Double):Double{
        return a+b
    }
    fun add(a:Int,b:Int,c:Int):Int{
        return a+b+c
    }
}

 open class Shape{
    open fun draw(){
        println("Drawing shape ")
    }
}
class Circle:Shape(){
    override fun draw() {
       println("Drawing Circle")
    }
}
//Data Class
data class Person(val name: String,val age:Int)

//Open Class

open class Shape1{
    open fun draw(){
        println("Drawing shape ")
    }
}
class Circle1:Shape1(){
    override fun draw() {
        println("Drawing Circle")
    }
}
//enum
enum class Color{
    RED,GREEN, BLUE
}

//Higher Order Function
fun calculator(x:Int,y:Int,others:(Int,Int)->Int):Int{
    return others(x,y)
}
fun add(a:Int,b:Int):Int{
    return a+b
}
fun subtract(a:Int,b:Int):Int{
    return a-b
}
fun main(){
    //Abstract Claa
//   val  eng = Engineer("Randhir",5)
//    eng.employeeDetails()
//    eng.dob("2 October ")


    //Overloading
//    val opertion= MathOpertion()
//    println(opertion.add(2,3))
//    println(opertion.add(2.5,3.5))
//    println(opertion.add(2,3,6))

    //OverRiding
//    val circle = Circle()
//    println(circle.draw())

    //Implementing Data Class
//    val person = Person("Randhir",28)
//    val person1 = Person("Randhir",29)
//    println(person==person1)
//    println(person)
//
//    //Enum
//    val color= Color.BLUE

    val result= calculator(10,5,::add)
    println("Addition: $result " )

    val result1= calculator(10,5,::subtract)
    println("Subtraction : $result1 " )

}