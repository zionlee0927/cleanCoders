package tdd.wordwrap

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class WordwrapTest{
    private val wordwrap = Wordwrap()

    @Test
    fun wrapGettingStuck1(){
        assertThat(wordwrap.wrapGettingStuck("word word", 4)).isEqualTo("word\nword")
    }

    @Test
    fun wrapGettingStuck2(){
        assertThat(wordwrap.wrapGettingStuck("a dog", 5)).isEqualTo("a dog")
    }

    @Test
    fun wrapGettingStuck3(){
        assertThat(wordwrap.wrapGettingStuck("a dog with a bone", 6)).isEqualTo("a dog\nwidth\n a\nbone")
    }

}