package com.pedromassango.crypto.ui.exchange

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
            Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
            handleComponentsVisibility( showProgress = false)
        })
        exchangeViewModel.exchangeResult.observe(this, Observer {
            tv_exchange_result.text = it.toString()
            handleComponentsVisibility( showProgress = false)
        })
    }

    private fun startExchanging() {
        val valueToExchange = edt_exchange.text.toString()
        val currency = spinner_currency.selectedItem.toString()

        // check field
        if(valueToExchange.trim().isEmpty())
            return

        handleComponentsVisibility( showProgress = true)
        exchangeViewModel.onExchangeClicked(currency, valueToExchange)
    }

    private fun handleComponentsVisibility(showProgress: Boolean) {
        edt_exchange.isEnabled = !showProgress
        btn_exchange.isEnabled = !showProgress
        btn_invert.isClickable = !showProgress
        spinner_currency.isEnabled = !showProgress

        progress_bar.visibility = if(showProgress) View.VISIBLE else View.GONE
    }
}