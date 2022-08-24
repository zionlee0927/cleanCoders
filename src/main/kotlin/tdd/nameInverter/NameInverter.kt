package tdd.nameInverter

class NameInverter {
    fun inverter(name: String?): String{
        if (name.isNullOrBlank()) return ""

        val split = name.trim().split(" ").toMutableList()

        removeHonorific(split)

        var invertedName = "${split.last()}, ${split.first()}"

        extractPostNominals(split)
            ?.let { invertedName = addPostNominals(it, split) }

        return if (split.size > 1) invertedName
        else split.first()
    }

    private fun addPostNominals(
        postNominals: String,
        split: MutableList<String>
    ) = "${split.last()}, ${split.first()} $postNominals"

    private fun extractPostNominals(split: MutableList<String>): String? {
        val postNominals = listOf("Sr.")
        val last = split.last()
        return if (postNominals.contains(last)) split.removeLast()
        else null
    }

    private fun removeHonorific(split: MutableList<String>) {
        val honorific = listOf("Mr.", "Mrs.")
        val first = split[0]
        if (honorific.contains(first)) split.removeFirst()
    }
}