package polije.kuliah.topupin.presentation.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import polije.kuliah.topupin.R
import polije.kuliah.topupin.data.model.Product
import polije.kuliah.topupin.databinding.ListItemproductBinding


class ProductAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val nameList = ArrayList<Product>()

    fun setList(data: List<Product>) {
        nameList.clear()
        nameList.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding : ListItemproductBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.list_itemproduct,
            parent,
            false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(nameList[position].kategori)
    }

}

class MyViewHolder(val binding: ListItemproductBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(name: String) {
        binding.tvItem.text = name
    }

}
