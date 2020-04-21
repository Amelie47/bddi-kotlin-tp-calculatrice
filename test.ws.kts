inline fun sum(a:Int,b:Int,callback: () -> Unit) {
    callback()
    println(a.plus(b))
}

sum(3,2,{
    println("Calcul en cours...")
})