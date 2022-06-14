package com.genesis.domain

import com.genesis.data.GetHearthstoneException
import com.genesis.data.HearthstoneRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetHearthsTest {

    private val repository = mockk<HearthstoneRepository>()

    private val getHearthstone = GetHearths(repository)

    @Test
    fun getHearthstone_return_list_with_success() = runBlocking {
        //GIVEN
        coEvery { repository.getHearthstone("Teste") } returns HearthstoneFactory.hearths

        //WHEN
        val result = getHearthstone("Teste")

        //THEN
        Assert.assertEquals(result.size, HearthstoneFactory.hearths.size)
    }

    @Test
    fun getHearthstone_return_exception() = runBlocking {
        //GIVEN
        coEvery { repository.getHearthstone("Teste") } throws  GetHearthstoneException()

        //WHEN
        val result = getHearthstone("Teste")

        //THEN
        Assert.assertEquals(result.size, HearthstoneFactory.hearths.size)
    }
}