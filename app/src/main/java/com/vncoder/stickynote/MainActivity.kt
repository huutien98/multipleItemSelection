package com.vncoder.stickynote

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vncoder.myapplication.MultiEmployee
import com.vncoder.myapplication.MultipleTypeAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btn_close
import kotlinx.android.synthetic.main.cutsom_layout.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        searchview.isIconified

        btn_add.setOnClickListener(this)
        btn_settting.setOnClickListener(this)
        btn_close.setOnClickListener(this)
        initView()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)



    }

    private fun initView() {
        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        createList()
    }

    private fun createList() {
        val employees = ArrayList<MultiEmployee>()
        var employee = MultiEmployee()
        employee.name = "Robert"
        employee.address = "New York"
        employee.phone = "+61234456"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Tom"
        employee.address = "California"
        employee.email = "tom_frank@gmail.com"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Smith"
        employee.address = "Philadelphia"
        employee.email = "smith_carrol@gmail.com"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Ryan"
        employee.address = "Canada"
        employee.phone = "+612001456"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Mark"
        employee.address = "Boston"
        employee.email = "mark_walmerd@gmail.com"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Adam"
        employee.address = "Brooklyn"
        employee.phone = "+61211780"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Kevin"
        employee.address = "New Jersey"
        employee.phone = "+94221035"
        employees.add(employee)
        employee.name = "Smith"
        employee.address = "Philadelphia"
        employee.email = "smith_carrol@gmail.com"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Ryan"
        employee.address = "Canada"
        employee.phone = "+612001456"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Mark"
        employee.address = "Boston"
        employee.email = "mark_walmerd@gmail.com"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Adam"
        employee.address = "Brooklyn"
        employee.phone = "+61211780"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Kevin"
        employee.address = "New Jersey"
        employee.phone = "+94221035"
        employees.add(employee)

        employee.name = "Adam"
        employee.address = "Brooklyn"
        employee.phone = "+61211780"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Kevin"
        employee.address = "New Jersey"
        employee.phone = "+94221035"
        employees.add(employee)
        employee.name = "Smith"
        employee.address = "Philadelphia"
        employee.email = "smith_carrol@gmail.com"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Ryan"
        employee.address = "Canada"
        employee.phone = "+612001456"
        employees.add(employee)
        employee = MultiEmployee()


        // set adapter
        val adapter = MultipleTypeAdapter(this, employees)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showDialog() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.cutsom_layout, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
        val  mAlertDialog = mBuilder.show()
            mAlertDialog.btn_close.setOnClickListener {
                mAlertDialog.dismiss()
            }
//        mAlertDialog.spinner.setOnClickListener {v ->
//            when(v.id){
//                R.id.spinner -> {
//                    val languages = resources.getStringArray(R.array.Languages)
//                    if (spinner != null) {
//                        val adapter = ArrayAdapter(this,
//                            android.R.layout.simple_spinner_item, languages)
//                        spinner.adapter = adapter
//                        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//                            override fun onItemSelected(
//                                parent: AdapterView<*>?,
//                                view: View?,
//                                position: Int,
//                                id: Long
//                            ) {
//                                Toast.makeText(applicationContext,"longgg",Toast.LENGTH_SHORT).show()
//                            }
//                            override fun onNothingSelected(parent: AdapterView<*>?) {
//                            }
//                        }
//                        }
//                }
//            }
//        }
        mAlertDialog.btn_done.setOnClickListener {
        }
    }

    override fun onClick(v: View?) {
        if (v != null){
            when(v.id){
                    R.id.btn_add ->{
                    showDialog()
                    }
            }
            when(v.id){
                    R.id.btn_settting ->{

                    }
            }
            when(v.id){
                R.id.btn_close ->{
                    System.exit(0)
                }
            }
        }
     }
}