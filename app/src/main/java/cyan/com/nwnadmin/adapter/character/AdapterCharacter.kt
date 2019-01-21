package cyan.com.nwnadmin.adapter.character

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cyan.com.nwnadmin.R
import cyan.com.nwnadmin.databinding.AdapterCharacterListBinding
import cyan.com.nwnadmin.model.data.PlayerCharacter

class AdapterCharacter(
    private val presenter: CharacterPresenter
) : RecyclerView.Adapter<AdapterCharacter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binder = DataBindingUtil.inflate<AdapterCharacterListBinding>(LayoutInflater.from(parent.context),
            R.layout.adapter_character_list,
            parent,
            false)
        val viewHolder = ViewHolder(binder.root)
        viewHolder.binder = binder
        return viewHolder
    }

    override fun getItemCount(): Int = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        presenter.displayCharacter(position, holder)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), CharacterView {
        lateinit var binder: AdapterCharacterListBinding

        override fun bindCharacter(character: PlayerCharacter) {
            binder.character = character
        }

        override fun setOnCharacterClickListener(position: Int) {
            itemView.setOnClickListener{ presenter.clickCharacter(position) }
        }
    }
}