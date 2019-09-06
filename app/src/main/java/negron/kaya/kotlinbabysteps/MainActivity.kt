package negron.kaya.kotlinbabysteps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.owner_dialog.view.*


class MainActivity : AppCompatActivity(), OnClickListener {
    override fun clickCard() {
        Log.e("MainActivity", "Aprentando card")
    }


    private lateinit var adapter: PetAdapter

    private lateinit var listPet: RecyclerView

    private lateinit var btnFilterByAge: Button

    private lateinit var btnFilterByOwner: Button

    private lateinit var btnFilterByOwnerAndAge: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = PetAdapter(this, this)

        setUpCommonWay()

//        setUpWithExtensions()

        adapter.replaceData(TestData.getPets())

    }

    private fun setUpCommonWay() {
        listPet = findViewById(R.id.list_pet)
        listPet.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        listPet.setHasFixedSize(true)
        listPet.adapter = adapter

        btnFilterByAge = findViewById(R.id.btn_filter_age)
        btnFilterByOwner = findViewById(R.id.btn_filter_owner)
        btnFilterByOwnerAndAge = findViewById(R.id.btn_filter_owner_and_age)

        btnFilterByOwnerAndAge.setOnClickListener { filterByOwnerAndAge() }
        btnFilterByOwner.setOnClickListener { filterByOwner() }
        btnFilterByAge.setOnClickListener { filterByAge() }
    }

    override fun showOwner(nameOwner: Owner) {
        val builder = AlertDialog.Builder(this)

        val view = LayoutInflater.from(this).inflate(R.layout.owner_dialog, null)
        view.text_name_owner.text = nameOwner.name

        builder.setView(view).create().show()
    }

    override fun showHumanAge(pet: Pet) {
        Snackbar.make(content, getString(R.string.format_age_human).ageText(age = pet.humanAge()), Snackbar.LENGTH_LONG).show()
    }

    private fun filterByAge() {
        val byAge = TestData.getPets().filter { it.age > 7 }
        adapter.replaceData(byAge)
    }

    private fun filterByOwner() {
        val byOwner = TestData.getPets().filter { it.owner != null }
        adapter.replaceData(byOwner)
    }

    private fun filterByOwnerAndAge() {
        val byOwnerAndAge = TestData.getPets().filter { it.owner != null }.filter { it.age > 8 }
                                                .sortedByDescending { it.age }
        adapter.replaceData(byOwnerAndAge)
    }
}
