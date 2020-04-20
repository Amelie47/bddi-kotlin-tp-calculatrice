fun String.sayHello():String {
    val retour = "$this - Hello world"
    return retour
}

val part1 = "Bonjour"
println(part1.sayHello())

data class Etudiant(var first:String, var last:String)

val etudiants = mutableListOf<Etudiant>()
etudiants.add(Etudiant("Valentin","Baud"))
etudiants.add(Etudiant("Amélie","Mouillac"))
etudiants.add(Etudiant("Cloé","Sarga"))
etudiants.add(Etudiant("Léo","Bateau"))

fun Etudiant.fullName() = "${this.first} ${this.last}"

// println(etudiant.fullName())


// Créer une focntion d'extension sur une liste d'étudiants qui
// inversera le nom et le prenom de chaque etudiant de la liste
etudiants.forEach {
    println(it.fullName())
}

/**fun Etudiant.switchNames() {
    var first = this.first
    var last = this.last

    this.first = last
    this.last = first

    println(this.fullName());
}*/

fun Etudiant.switch() = copy(first = last, last = first)

fun List<Etudiant>.switch() = forEach { it.switch() }

etudiants.switch()
etudiants.forEach {
    println(it.fullName())
}



