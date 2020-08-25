package com.assignment.Coroutine.feature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.Coroutine.Generic.ErrorResponse
import com.assignment.Coroutine.Generic.Response
import com.assignment.Coroutine.Generic.SuccessResponse
import com.assignment.Coroutine.Model.CountryDetails
import com.assignment.Coroutine.Model.Rows
import com.assignment.Coroutine.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_first.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: DetailViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity(), viewModelFactory).get(DetailViewModel::class.java)


        loadData()
    }
    private fun loadData(){
        viewModel.run {
            getCountryDetailsObservable().observe(viewLifecycleOwner, Observer<Response<CountryDetails, Throwable>> { response ->
                when (response) {
                    is SuccessResponse -> {
                        progreesBar.visibility = View.GONE
                        countryDetailsRecycleView.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
                        val adapter = CountryAdapter(response.data.rows as ArrayList<Rows>)
                        countryDetailsRecycleView.adapter = adapter
                    }
                    is ErrorResponse -> {
                        progreesBar.visibility = View.GONE
                        Toast.makeText(context, response.errorData?.message, Toast.LENGTH_LONG).show()
                    }
                }
            })
        }
    }
}