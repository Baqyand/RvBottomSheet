package com.baqynra.withbaqyand.rvbottomsheet

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.baqynra.withbaqyand.rvbottomsheet.adapter.ListlaptopAdapter
import com.baqynra.withbaqyand.rvbottomsheet.fragment.BottomSheetFragment
import com.baqynra.withbaqyand.rvbottomsheet.model.Laptop
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.tv_Harga
import kotlinx.android.synthetic.main.activity_main.tv_detail
import kotlinx.android.synthetic.main.activity_main.tv_nama
import kotlinx.android.synthetic.main.item_laptop.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_NAME = "Nama Kaos"
        const val EXTRA_DETAIL = "Detail Kaos"
        const val EXTRA_HARGA = "Harga Kaos"
        const val EXTRA_IMAGE = "Image"
        lateinit var nama:String
        lateinit var harga:String
        lateinit var detail:String

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        show_dialog.setOnClickListener {
            var dialog = BottomSheetFragment()
            dialog.show(supportFragmentManager, "custom")
        }
    }
    private val mMessageReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if(intent.hasExtra("Nama")){
                MainActivity.nama =intent.getStringExtra("Nama")!!
                MainActivity.harga =intent.getStringExtra("Harga")!!
                detail = intent.getStringExtra("Detail")!!


                tv_nama.text = MainActivity.nama
                tv_Harga.text = MainActivity.harga
                tv_detail.text = detail


            }
        }
    }
    override fun onResume() {
        super.onResume()
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(mMessageReceiver, IntentFilter("Data Ketrigger"))
    }

    override fun onPause() {
        super.onPause()
        LocalBroadcastManager.getInstance(this)
            .unregisterReceiver(mMessageReceiver)
    }




}