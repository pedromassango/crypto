package com.pedromassango.crypto.ui.exchange

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.pedromassango.crypto.R
import kotlinx.android.synthetic.main.exchange_fragment.*
import kotlinx.android.synthetic.main.exchange_fragment.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class ExchangeFragment: Fragment() {

    private val exchangeViewModel: ExchangeViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return with(inflater.inflate(R.layout.exchange_fragment, container, false)){

            btn_exchange.setOnClickListener {  startExchanging() }
            this
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        exchangeViewModel.error.observe(this, Observer {
            Snackbar.make(view!!, it, Snackbar.LENGTH_LONG).show()
        })
        exchangeViewModel.exchangeResult.observe(this, Observer {
            tv_exchange_result.text = it.toString()

            edt_exchange.isEnabled = true
            btn_exchange.isEnabled = true
            progress_bar.visibility = View.GONE
        })
    }

    private fun startExchanging() {
        val valueToExchange = edt_exchange.text.toString()
        val currency = spinner_currency.selectedItem.toString()

        edt_exchange.isEnabled = false
        btn_exchange.isEnabled = false
        progress_bar.visibility = View.VISIBLE

        exchangeViewModel.onExchangeClicked(currency, valueToExchange)
    }
}