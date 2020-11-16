package com.example.projectenam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textData = createPhoneData()
        rv_part.layoutManager = LinearLayoutManager(this)
        rv_part.setHasFixedSize(true)
        rv_part.adapter = ContactAdapter(textData, {phoneItem : PhoneData -> phoneItemClicked(phoneItem) })
    }

    private fun phoneItemClicked(phoneItem : PhoneData) {
        val showDetailActivityIntent = Intent(this, PhoneDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TITLE, phoneItem.contactName)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, phoneItem.phone.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEMPLATE, phoneItem.email)
        startActivity(showDetailActivityIntent)

    }

    private fun createPhoneData(): List<PhoneData> {
        val partList = ArrayList<PhoneData>()
        partList.add(PhoneData("Aldo","085105991200","rivaldohadi@gmail.com"))
        partList.add(PhoneData("Ibrahim","081330059927","ibrahim23@gmail.com"))
        partList.add(PhoneData("Joyo","081249016492", "cahyojoyo@gmail.com"))
        partList.add(PhoneData("Kiki","082333811976", "primandikahakiki@gmail.com"))
        partList.add(PhoneData("Puji","083830694069", "pratamapuji@gmail.com"))
        return partList
    }

}