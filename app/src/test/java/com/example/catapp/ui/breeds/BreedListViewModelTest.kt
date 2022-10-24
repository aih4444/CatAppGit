package com.example.catapp.ui.breeds

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.catapp.Application
import com.example.catapp.network.CatApiService
import com.example.catapp.util.LoadState
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.withContext
import org.junit.After
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class BreedListViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var applicationMock: Application

    @MockK
    private lateinit var serviceMock: CatApiService

    private lateinit var subject: BreedListViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        MockKAnnotations.init(this)
        subject = BreedListViewModel(applicationMock, serviceMock)
    }

    @Test
    fun updateListPopulatesListOfBreeds() = runBlocking {
        withContext(Dispatchers.Main) {
            subject.updateList()
//            val type = subject.listOfBreeds.value
            coVerify { serviceMock.getAllBreeds() }
        }
    }

    @After
    fun teardown(){
        Dispatchers.resetMain()
    }
}