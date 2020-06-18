package com.vncoder.myapplication

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vncoder.stickynote.R
import java.util.*

class MultipleTypeAdapter(private val context: Context, private val employees: ArrayList<MultiEmployee>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        return if (viewType == TYPE_CALL) { // for call layout
            view = LayoutInflater.from(context).inflate(R.layout.call_item, viewGroup, false)
            CallViewHolder(view)
        } else { // for email layout
            view = LayoutInflater.from(context).inflate(R.layout.mail_item, viewGroup, false)
            EmailViewHolder(view)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (TextUtils.isEmpty(employees[position].email)) {
            TYPE_CALL
        } else {
            TYPE_EMAIL
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TYPE_CALL) {
            (viewHolder as CallViewHolder).setCallDetails(employees[position])
        } else {
            (viewHolder as EmailViewHolder).setEmailDetails(employees[position])
        }
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    internal inner class CallViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtName: TextView
        private val txtAddress: TextView
        fun setCallDetails(employee: MultiEmployee) {
            txtName.text = employee.name
            txtAddress.text = employee.address
        }

        init {
            txtName = itemView.findViewById(R.id.txtName)
            txtAddress = itemView.findViewById(R.id.txtAddress)
        }
    }

    internal inner class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtName: TextView
        private val txtAddress: TextView
        fun setEmailDetails(employee: MultiEmployee) {
            txtName.text = employee.name
            txtAddress.text = employee.address
        }

        init {
            txtName = itemView.findViewById(R.id.txtName)
            txtAddress = itemView.findViewById(R.id.txtAddress)
        }
    }

    companion object {
        private const val TYPE_CALL = 1
        private const val TYPE_EMAIL = 2
    }

}