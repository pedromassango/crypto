package com.pedromassango.crypto.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.android.material.chip.Chip
import com.pedromassango.crypto.R
import com.pedromassango.crypto.data.Symbol
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModel()

    private val adapter: SymbolsAdapter by lazy {
        SymbolsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return with(inflater.inflate(R.layout.main_fragment, container, false)) {
            this
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mainViewModel.error.observe(this, Observer {
            handleProgress(false)
            Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
        })
        mainViewModel.symbols.observe(this, Observer {
            handleProgress(false)
            adapter.add(it)

            // start loading symbols detail, then update adapter
            loadDetailsAnd(it)
        })

        handleProgress(true)
        mainViewModel.onLoadSymbols()
    }

    private fun loadDetailsAnd(data: List<Symbol>?) {
        data?.let {
            it.forEach {
                mainViewModel.onLoadSymbolDetails(it.assetID!!).observe(this, Observer{ updatedSymbol ->
                    adapter.update(updatedSymbol)
                })
            }
        }
    }

    private fun handleProgress(show: Boolean) {
        progress_main?.visibility = if (show) View.VISIBLE else View.GONE
    }

}
