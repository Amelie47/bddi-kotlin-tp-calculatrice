package com.gmail.ameliemouillacpro.testandroid

open class OperationType : Storage(){

    var type = EnumOperationType.NULL

    enum class EnumOperationType(var type: String){
        MULTIPLE("*"),
        DIVIDE("/"),
        MINUS("-"),
        PLUS("+"),
        NULL("")
    }
}