package tdd.nameInverter

class NameInverter {
    fun inverter(name: String?): String{
        if (name.isNullOrBlank()) return ""

        val split = splitNames(name)

        removeHonorific(split)

        if (split.size == 1) return split[0]

        var invertedName = "${split[1]}, ${split[0]}"

        extractPostNominals(split)
            ?.let { invertedName = addPostNominals(it, split) }

        return invertedName

    }

    private fun splitNames(name: String)
    = name.trim().split(" ")
        .filter { it.isNotEmpty() }
        .toMutableList()

    private fun removeHonorific(split: MutableList<String>) {
        val honorific = listOf("Mr.", "Mrs.")
        val first = split[0]
        if (honorific.contains(first)) split.removeFirst()
    }

    private fun addPostNominals(
        postNominals: String,
        split: MutableList<String>
    ) = "${split[1]}, ${split[0]} $postNominals"

    private fun extractPostNominals(split: MutableList<String>): String? {
        return if (split.size > 2)
            split.subList(2, split.size).joinToString(" ")
        else null
    }
}