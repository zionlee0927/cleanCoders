package tdd.wordwrap

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WordwrapTest{

    @Test
    fun wrapGettingStuck1(){
        assertThat(wrapGettingStuck("word word", 4)).isEqualTo("word\nword")
    }

    private fun wrapGettingStuck(string: String, width: Int): String {
        return string.replace(" ", "\n")
    }
}