package tdd.wordwrap

class Wordwrap {
    fun wrapGettingStuck(string: String, width: Int): String {
        return if (string.length > width) string.replace(" ", "\n") else string
    }

    fun wrap(string: String?, width: Int): String {
        return if (string.isNullOrEmpty()) ""
        else string
    }
}