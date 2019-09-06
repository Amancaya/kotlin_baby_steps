package negron.kaya.kotlinbabysteps


fun String.ageText(age: Int = 1): String {
    return this.format(age)
}

fun Pet.humanAge() = this.age * 7

