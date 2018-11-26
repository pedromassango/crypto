package com.pedromassango.crypto.ui.exchange

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pedromassango.crypto.R
import kotlinx.android.synthetic.main.exchange_fragment.*
import kotlinx.android.synthetic.main.exchange_fragment.view.*

class ExchangeFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return with(inflater.inflate(R.layout.exchange_fragment, container, false)){

            btn_exchange.setOnClickListener {  startExchanging() }
            this
        }
    }

    private fun startExchanging() {
        val valueToExchange = edt_exchange.text.toString()
        val currency = spinner_currency.selectedItem.toString()
    }
}