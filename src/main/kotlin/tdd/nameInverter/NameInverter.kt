package tdd.nameInverter

class NameInverter {
    fun inverter(name: String?): String{
        if (name.isNullOrBlank()) return ""
        val split = name.trim().split(" ")
        return if (split.size > 1) "${split[split.lastIndex]}, ${split[0]}"
        else split[0]
    }
}