import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas11.R
import com.example.tugas11.User
import com.squareup.picasso.Picasso

class UserAdapter(
    private val userList: List<User>,
    private val onItemClickListener: (User) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName: TextView = itemView.findViewById(R.id.textName)
        val textEmail: TextView = itemView.findViewById(R.id.textEmail)
        val imageUser: ImageView = itemView.findViewById(R.id.imageUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.textName.text = user.name
        holder.textEmail.text = user.email
        Picasso.get().load(user.imageUrl).into(holder.imageUser)

        holder.itemView.setOnClickListener {
            onItemClickListener(user)
        }
    }

    override fun getItemCount(): Int = userList.size
}
