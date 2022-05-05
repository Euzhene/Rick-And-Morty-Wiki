package com.euzhene.rickandmorty.data

import com.euzhene.rickandmorty.data.mapper.CharacterMapper
import com.euzhene.rickandmorty.data.network.dto.CharacterDto
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class MapperTest {
    private lateinit var mapper: CharacterMapper

    @Before fun setUp() {
        mapper = CharacterMapper()
    }

    @Test
    fun test_null_value() {
        val characterDto = CharacterDto(
            "22/01/2019",
            emptyList(),
            "Male",
            2,
            "url",
            null,
            "Morty",
            null,
            "Human",
            "Alive",
            "",
            "url"
        )
        assertThat(mapper.mapDtoToEntity(characterDto).location).isEmpty()
    }
}