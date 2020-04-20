package com.gmail.ameliemouillacpro.testandroid

open class Operation: OperationType() {

    fun setOperator(type:String) {
        when(type) {
            "*" -> this.type = EnumOperationType.MULTIPLE
            "/" -> this.type = EnumOperationType.DIVIDE
            "-" -> this.type = EnumOperationType.MINUS
            "+" -> this.type = EnumOperationType.PLUS
        }
    }

    private fun applyOffset(original:Double?, newValue:Double, offset:Double):Double {
        if (original != null) {
            return original * offset + newValue
        } else {
            return newValue
        }
    }

    fun addValue(x:Double) {
        if (this.type != EnumOperationType.NULL) {
            this.b = this.applyOffset(this.b, x, 10.0)
        }else {
            this.a = this.applyOffset(this.a, x, 10.0)
        }
    }

    override fun clear() {
        this.type = EnumOperationType.NULL
        super.clear()
    }
}