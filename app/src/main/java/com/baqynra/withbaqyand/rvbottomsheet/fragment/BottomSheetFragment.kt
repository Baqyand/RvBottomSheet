package com.baqynra.withbaqyand.rvbottomsheet.fragment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.baqynra.withbaqyand.rvbottomsheet.MainActivity
import com.baqynra.withbaqyand.rvbottomsheet.R
import com.baqynra.withbaqyand.rvbottomsheet.adapter.ListlaptopAdapter
import com.baqynra.withbaqyand.rvbottomsheet.model.Laptop
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*
import kotlinx.android.synthetic.main.fragment_bottom_sheet.view.*

class BottomSheetFragment : BottomSheetDialogFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
        view.iv_close.setOnClickListener{
            dismiss()
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dataArray.clear()
        dataArray.add(Laptop("ROG ZEPHIRUZ G14","RP. 18.000.000","Ini Adalah Laptop ",R.drawable.rog))
        dataArray.add(Laptop("ROG ZEPHIRUZ G14","RP. 19.000.000","ini adalah ",R.drawable.rog))
        adapter = ListlaptopAdapter(requireContext())
        rvlaptop.layoutManager = LinearLayoutManager(requireActivity())
        rvlaptop.adapter = adapter

        adapter.initData(dataArray)
    }


    companion object {

        private var dataArray  = ArrayList<Laptop>()
        private lateinit var adapter: ListlaptopAdapter
        lateinit var nama:String
        lateinit var harga:String
        lateinit var detail:String
    }
}