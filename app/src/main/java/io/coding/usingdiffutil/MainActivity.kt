package io.coding.usingdiffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.coding.usingdiffutil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //ViewBinding to R.layout.activity_main
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    //Create the Adapter
    private val adapter by lazy { UserAdapter() }

    //list of users
    private val data = listOf(User("Aaron",33),User("Leo",6),User("Cody",30))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Change setContentView(R.layout.activity_main) to
        setContentView(binding.root)
        setupList()
        binding.fabReverse.setOnClickListener {
            reverseList()
        }
    }

    private fun reverseList() {
        adapter.submitList(adapter.currentList.reversed())
    }

    private fun setupList(){
        //link the recycler view to the adapter
        binding.list.adapter = adapter
        //add a bit of decor
        binding.list.addItemDecoration(DividerItemDecoration(this,
            LinearLayoutManager.VERTICAL))
        //set the data
        adapter.submitList(data)
    }




}