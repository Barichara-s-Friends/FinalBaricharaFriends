package com.barichara.sitio.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.barichara.sitio.databinding.FragmentListBinding
import com.barichara.sitio.main.MainActivity
import com.barichara.sitio.model.Sitio
import com.barichara.sitio.model.SitioItem
import com.google.gson.Gson

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var sitioAdapter: SitioAdapter
    private lateinit var listSitio: ArrayList<SitioItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listSitio = loadMockSitioFromJson()
        sitioAdapter = SitioAdapter(listSitio, onItemClicked = { onSitioClicked(it) } )

        listBinding.sitioRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitioAdapter
            setHasFixedSize(false)
        }

    }

    private fun onSitioClicked(Sitio: SitioItem) {
       findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(Sitio))
    }

    private fun loadMockSitioFromJson(): ArrayList<SitioItem> {
        val sitioString: String = context?.assets?.open("sitio.json")?.bufferedReader().use { it!!.readText() } //TODO reparar !!
        val gson = Gson()
        val sitioList = gson.fromJson(sitioString, Sitio::class.java)
        return sitioList
    }
}