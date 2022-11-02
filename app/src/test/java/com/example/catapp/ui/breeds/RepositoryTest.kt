package com.example.catapp.ui.breeds

import com.example.catapp.network.CatApiService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class RepositoryTest {

    private val apiServiceMock: CatApiService = mockk {
        coEvery { getAllBreeds() } returns Response.success(emptyList())
    }

    private lateinit var subject: Repository

    @Before
    fun setUp() {
        subject = Repository(apiServiceMock)
    }

    @Test
    fun getAllBreeds() {
        runBlocking { subject.getAllBreeds() }

        coVerify { apiServiceMock.getAllBreeds() }
    }
}