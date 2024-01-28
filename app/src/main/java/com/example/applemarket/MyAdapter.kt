import android.content.Intent
import android.icu.text.Transliterator.Position
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.DetailActivity
import com.example.applemarket.MyItem
import com.example.applemarket.databinding.ItemRecyclerviewBinding
import java.text.NumberFormat

class MyAdapter(val myItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int, myItem: MyItem)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        Log.d("MyAdapter", "onCreateViewHolder()")
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            val clickedItem = myItems[position]
            itemClick?.onClick(it, position, clickedItem)

            // Intent 생성
            val intent = Intent(it.context, DetailActivity::class.java)

            // Percelize
            intent.putExtra("EXTRA_MY+ITEM", clickedItem)

            // DetailActivity 시작
            it.context.startActivity(intent)
        }

        // 리사이클러뷰 목록
        holder.iconItem.setImageResource(myItems[position].Image)
        holder.itemTitle.text = myItems[position].ItemTitle
        holder.Adress.text = myItems[position].Address

        val formattedPrice = NumberFormat.getInstance().format(myItems[position].price)
        holder.itemPrice.text = "$formattedPrice"+"원"
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return myItems.size
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val iconItem = binding.iconItem
        val itemTitle = binding.itemTitle
        val Adress = binding.Adress
        val itemPrice = binding.itemPrice
    }
}
