package com.gmail.ameliemouillacpro.testandroid

class Calculus : Operation(){

    fun execute(): Double {
        var value = 0.0
        if(this.a != null && this.b != null && this.type != EnumOperationType.NULL){
            when(this.type){
                EnumOperationType.PLUS -> value = this.a!! + this.b!!
                EnumOperationType.MINUS -> value = this.a!! - this.b!!
                EnumOperationType.MULTIPLE -> value = this.a!! * this.b!!
                EnumOperationType.DIVIDE -> value = this.a!! / this.b!!
            }
        }
        return value
    }

    fun stringRepresentation(): String {
        var str = ""

        if(this.a != null) {
            str += this.a.toString()
        }
        if(this.type != null) {
            str += this.type.type
        }
        if(this.b != null) {
            str += this.b.toString()
        }

        return str
    }
}
