package com.pedromassango.crypto.ui.exchange

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pedromassango.crypto.R

class ExchangeFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return with(inflater.inflate(R.layout.exchange_fragment, container, false)){
            this
        }
    }
}