package tdd.wordwrap

class Wordwrap {
    fun wrapGettingStuck(string: String, width: Int): String {
        return if (string.length > width) string.replace(" ", "\n") else string
    }

    fun wrap(string: String?, width: Int): String {
        if (string.isNullOrEmpty()) return ""

        if (string.length <= width) return string

        var breakPoint = string.lastIndexOf(" ", width)

        if (breakPoint == -1) breakPoint = width

        return string.substring(0,breakPoint)+"\n"+wrap(string.substring(breakPoint).trim(),width)
    }
}