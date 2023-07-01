package com.demo.demogeeks
 fun main(){
   // Declare Variable
//   var strTye="Kotlin"
//   val salary=10000
//     strTye="Java"

   //Kotlin Data Type
    //Define Number
    /* val num:Int = 1000
     val d:Double=100.00
     val f:Float= 100.00f
     val l:Long = 100000000000004

     println("Int value "+num)
     println("Double value "+d)
     println("Float value "+f)
     println("Long value "+l)
     */


   //Define Character
//    val newChar:Char='A'
//    println(newChar)
//     val bol:Boolean=true
//     println(bol)
//     val str:String="Hello World"
//     println(str)

    // val arrayType= arrayOf(1,2,3,4,5)

     //Kotlin Operators
     //Arithmetic Operator(+,-,*,/,%)

//     var a=11
//     var b=5
//     println(a+b)
//     println(a-b)
//     println(a*b)
//     println(a/b)
//     println(a%b)
     //Relation Operator(<,>)
     //Assignment Operator(=)
     //Unary Operator(++,--)
     //Logical Operators(&&, ||)

     //Control Flow
     //If Else
//     val num1=50
//     val num2=20
//     val result =if(num1 > num2){
//         "$num1 is greater than $num2"
//     } else{
//         "$num2 is greater than $num1"
//     }
//     println(result)
//

     //When
//     var days=9
//     var weekdays=when(days){
//         1 -> "Monday"
//         2 -> "Tuesday"
//         3 -> "Wednesday"
//         4 -> "Thursday"
//         5 -> "Friday"
//         6 -> "Saturday"
//         7 -> "Sunday"
//         else ->"Invalid Day"
//
//     }
//     println(weekdays)
     //While
//     var i=5;
//     while (i>0){
//         println(i)
//         i--
//     }
     //For Loop
//      for (i in 1..10){
//          println(i)
//      }
     //Step Up
//     for (i in 1..10 step 2){
//         println(i)
//     }
//     //StepDown
//     for (i in 10 downTo 1 step 5){
//         println(i)
//     }
//     val arrayType= arrayOf(1,2,3,4,5)
//     for (i in 0..arrayType.size-1){
//         println(arrayType[i])
//     }

     //Create Class Object
     val obj= myClass()
      val sum =obj.printName(5,9)
      println(sum)
 }

class myClass(){
  var name:String ="GeeksforGeeks"
    fun  printName(a:Int,b:Int):Int{
        //println("I am learning from "+ name)

        return a+b
    }
}
