package com.example.recyclerviewhttprequests.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewhttprequests.R
import com.example.recyclerviewhttprequests.adapters.MyAdapter
import com.example.recyclerviewhttprequests.fragments.F1
import com.example.recyclerviewhttprequests.fragments.F2
import com.example.recyclerviewhttprequests.fragments.F3
import com.example.recyclerviewhttprequests.interfaces.ActivityFragmentCommunication
import com.example.recyclerviewhttprequests.interfaces.OnUserItemClick
import com.example.recyclerviewhttprequests.models.Post
import com.example.recyclerviewhttprequests.models.User

class MainActivity : AppCompatActivity(), ActivityFragmentCommunication {
    val users: ArrayList<User> = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFirstFragmentFragment()
        //setUpRecyclerView()
    }
    fun setUpRecyclerView() {

        val recyclerView: RecyclerView = findViewById(R.id.recyclerlist)
        val layoutManager: LinearLayoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        // val layoutManager: GridLayoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        users.clear()
        val posts: ArrayList<Post> = ArrayList<Post>();
        posts.add(Post("1", "FirstPost", "shbdfhjbf"))
        posts.add(Post("2", "SecondPost", "shbdfhjbf"))
        posts.add(Post("3", "ThirdPost", "shbdfhjbf"))

        users.add(User( "Andreea", posts))
       // var adapter: MyAdapter = MyAdapter(users, )

       // recyclerView.adapter = adapter

    }
    private fun addFirstFragmentFragment() {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        val firstFragment = F1.newInstance("", "")
        val tag = F1::class.java.name

        val addTransaction = transaction.add(
            R.id.frame_layout, firstFragment, tag
        )

        //addTransaction.addToBackStack(tag)
        addTransaction.commit()

    }
    override fun replaceWithF2() {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        val tag = F1::class.java.name

        val replaceTransaction = transaction.add(
            R.id.frame_layout, F2.newInstance("", ""), tag
        )
        replaceTransaction.addToBackStack(tag)

        replaceTransaction.commit()
    }
    override fun replaceWithF3() {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        val tag = F2::class.java.name

        val replaceTransaction = transaction.add(
            R.id.frame_layout, F3.newInstance("", ""), tag
        )
        replaceTransaction.addToBackStack(tag)

        replaceTransaction.commit()
    }

}