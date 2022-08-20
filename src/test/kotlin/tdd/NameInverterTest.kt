package tdd

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import tdd.nameInverter.NameInverter

internal class NameInverterTest{
    private val nameInverter: NameInverter = NameInverter()

    @Test
    fun given_null___returns_empty_string(){
        assertThat(nameInverter.inverter(null)).isEqualTo("")
    }

    @Test
    fun given_empty_string___returns_empty_string(){
        assertThat(nameInverter.inverter("")).isEqualTo("")
    }

    @Test
    fun given_simple_name___returns_simple_name(){
        assertThat(nameInverter.inverter("lee")).isEqualTo("lee")
    }
}