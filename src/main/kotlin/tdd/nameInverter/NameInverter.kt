package tdd.nameInverter

class NameInverter {
    fun inverter(name: String?): String{
        if (name.isNullOrBlank()) return ""
        val split = name.trim().split(" ").toMutableList()
        removeHonorific(split)
        return if (split.size > 1) "${split[split.lastIndex]}, ${split[0]}"
        else split[0]
    }

    private fun removeHonorific(split: MutableList<String>) {
        val honorific = listOf("Mr.", "Mrs.")
        val first = split[0]
        if (honorific.contains(first)) split.removeFirst()
    }
}