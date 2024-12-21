package polije.kuliah.topupin.presentation.user.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import polije.kuliah.topupin.R
import polije.kuliah.topupin.databinding.CategoryItemBinding

class ProductCategoryAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val nameList = ArrayList<String>()
    private var listener: ((String) -> Unit)? = null
    fun setList(names: List<String>) {
        nameList.clear()
        nameList.addAll(names)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding: CategoryItemBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.category_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        return holder.bind(nameList[position],listener)
    }
    fun setOnItemClickListener(listener: (String) -> Unit) {
        this.listener = listener
    }
}

class MyViewHolder(val binding: CategoryItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(name: String,listener: ((String) -> Unit)?) {
        binding.categoryButton.text = name
        binding.categoryButton.setOnClickListener {
            listener?.invoke(name)
        }
    }
}