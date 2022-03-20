package io.coding.usingdiffutil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.coding.usingdiffutil.databinding.CellUserBinding

object UserDiffUtil : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        //This is to check if the item its self is the same this will use the equality function of the object.
        //Alternatively if you are using a database and have a id you can you that.
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        //This Goes a bit deeper and checks to make sure the data of the object is the same.
        return oldItem.name == newItem.name && oldItem.age == newItem.age
    }

//    override fun getChangePayload(oldItem: User, newItem: User): Any? {
//        return super.getChangePayload(oldItem, newItem)
//    }
}

//The UserAdapter using the ListAdatper, UserViewHolder, and UserDiffUtil
class UserAdapter : ListAdapter<User,UserViewHolder>(UserDiffUtil) {

    //Actually creates the View group for the cell.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        //Just like in the Activity we are going to use ViewBinding,
        //Just be sure to use the right inflate command or nothing will show in the cell.
        val binding = CellUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding)
    }

    //Binds the data to the cell.
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position) //gets the item at that index in the list.
        holder.bindCell(user)
    }

}

//View Holder is the same as it was but now we are using ViewBinding for easy linking.
class UserViewHolder(private val binding: CellUserBinding) : RecyclerView.ViewHolder(binding.root){

    //Binds the data to Each Cell
    fun bindCell(user:User){
        //Bad developer you should never put hard coded string in your code use string resources....
        //https://developer.android.com/guide/topics/resources/string-resource#formatting-strings
        binding.tvName.text = "User: ${user.name}"
        binding.tvAge.text = "Age: ${user.age}"
    }

}