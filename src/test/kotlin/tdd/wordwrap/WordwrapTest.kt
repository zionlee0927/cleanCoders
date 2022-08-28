package tdd.wordwrap

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class WordwrapTest{

    @Test
    fun wrapGettingStuck1(){
        assertThat(wrapGettingStuck("word word", 4)).isEqualTo("word\nword")
    }

    @Test
    fun wrapGettingStuck2(){
        assertThat(wrapGettingStuck("a dog", 5)).isEqualTo("a dog")
    }

    private fun wrapGettingStuck(string: String, width: Int): String {
        return if (string.length > width) string.replace(" ", "\n") else string
    }
}