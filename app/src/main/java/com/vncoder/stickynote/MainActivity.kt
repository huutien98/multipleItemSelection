package com.vncoder.stickynote

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vncoder.myapplication.MultiEmployee
import com.vncoder.myapplication.MultipleTypeAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cutsom_layout.*
import kotlinx.android.synthetic.main.cutsom_layout.view.*
import kotlinx.android.synthetic.main.cutsom_layout.view.btn_done
import kotlinx.android.synthetic.main.default_item.view.*

import java.util.ArrayList

class MainActivity : AppCompatActivity()  {
    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        btn_add.setOnClickListener { showDialog() }

        initView()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)



    }

    private fun initView() {
        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
//        createList()
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
        employee.another = "t3"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Mark"
        employee.address = "Boston"
        employee.email = "mark_walmerd@gmail.com"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Adam"
        employee.address = "Brooklyn"
        employee.another = "t7"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Kevin"
        employee.address = "New Jersey"
        employee.phone = "+94221035"
        employees.add(employee)

        employee.name = "Ryan"
        employee.address = "Canada"
        employee.another = "t6"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Mark"
        employee.address = "Boston"
        employee.email = "mark_walmerd@gmail.com"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Adam"
        employee.address = "Brooklyn"
        employee.another = "t5"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Adam"
        employee.address = "Brooklyn"
        employee.phone = "+61211780"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Smith"
        employee.address = "Philadelphia"
        employee.email = "smith_carrol@gmail.com"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Smith"
        employee.address = "Philadelphia"
        employee.email = "smith_carrol@gmail.com"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Smith"
        employee.address = "Philadelphia"
        employee.email = "smith_carrol@gmail.com"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Smith"
        employee.address = "Philadelphia"
        employee.email = "smith_carrol@gmail.com"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Adam"
        employee.address = "Brooklyn"
        employee.another = "t1"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Kevin"
        employee.address = "New Jersey"
        employee.phone = "+94221035"
        employees.add(employee)

        employee.name = "Adam"
        employee.address = "Brooklyn"
        employee.another = "t2"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Kevin"
        employee.address = "New Jersey"
        employee.another = "t3"
        employees.add(employee)

        employee.name = "Smith"
        employee.address = "Philadelphia"
        employee.another = "t3"
        employees.add(employee)
        employee = MultiEmployee()

        employee.name = "Ryan"
        employee.address = "Canada"
        employee.another = "t4"
        employees.add(employee)
        employee = MultiEmployee()


        // set adapter
        val adapter = MultipleTypeAdapter(this, employees)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = adapter
    }


    private fun showDialog(){
        val dialog = LayoutInflater.from(this).inflate(R.layout.cutsom_layout,null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(dialog)
            .setTitle(null)
        val mAlertDialog = mBuilder.show()

        val done = dialog.btn_done

        dialog.btn_close.setOnClickListener { mAlertDialog.dismiss() }

        done.setOnClickListener {
            val Note = dialog.edt_note.text.toString()
            val employees = ArrayList<MultiEmployee>()
            var employee = MultiEmployee()
            
            employee.note = Note
            employees.add(employee)


            val adapter = MultipleTypeAdapter(this, employees)
            adapter.notifyDataSetChanged()
            recyclerView!!.layoutManager = LinearLayoutManager(this)
            recyclerView!!.adapter = adapter

            mAlertDialog.dismiss()
        }
    }




}