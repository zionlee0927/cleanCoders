package tdd.wordwrap

class Wordwrap {
    fun wrapGettingStuck(string: String, width: Int): String {
        return if (string.length > width) string.replace(" ", "\n") else string
    }

    fun wrap(string: String?, width: Int): String {
        if (string.isNullOrEmpty()) return ""

        if (string.length <= width) return string

        return string.substring(0,width)+"\n"+wrap(string.substring(width).trim(),width)
    }
}