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

    @Test
    fun given_first_last___returns_last_first(){
        assertThat(nameInverter.inverter("First Last")).isEqualTo("Last, First")
    }

    @Test
    fun given_simple_name_with_leading_spaces___returns_simple_name(){
        assertThat(nameInverter.inverter(" Name")).isEqualTo("Name")
    }
}