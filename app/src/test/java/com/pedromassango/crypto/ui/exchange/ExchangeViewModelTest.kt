package com.pedromassango.crypto.ui.exchange

import com.pedromassango.crypto.data.BlockchainApiRepository
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ExchangeViewModelTest {

    private lateinit var exangeViewModel: ExchangeViewModel

    @Mock
    lateinit var repo: BlockchainApiRepository

    @Before
    fun setUp() {
        //MockitoAnnotations.initMocks(this)
        //exangeViewModel = ExchangeViewModel(repo)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getError() {
    }

    @Test
    fun getExchangeResult() {
    }

    @Test
    fun onExchangeClicked() {
       // exangeViewModel.onExchangeClicked(currency = "USD", valueToExchange = "1000")

    }
}