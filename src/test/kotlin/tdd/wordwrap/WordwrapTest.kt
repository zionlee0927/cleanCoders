package tdd.wordwrap

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class WordwrapTest{
    private val wordwrap = Wordwrap()
/*
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
*/

    @Test
    fun wrap_given_null_return_empty(){
        assertThat(wordwrap.wrap(null, 1)).isEqualTo("")
    }

    @Test
    fun wrap_given_x_return_x(){
        assertThat(wordwrap.wrap("x", 1)).isEqualTo("x")
    }

    @Test
    fun wrap_given_xx_return_xnx(){
        assertThat(wordwrap.wrap("xx", 1)).isEqualTo("x\nx")
    }
}