package com.diegolima.rxjavaclass.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegolima.rxjavaclass.R
import com.diegolima.rxjavaclass.db.Repo
import kotlinx.android.synthetic.main.stars_item.view.*

class GithubRepoAdapter() : RecyclerView.Adapter<GithubRepoAdapter.StarRepoViewHolder>() {

    val data = ArrayList<Repo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarRepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stars_item, parent, false)
        return StarRepoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: StarRepoViewHolder, position: Int) {
        viewHolder.repoName.text = data[position].name
        viewHolder.repoStarsCount.text = data[position].starCount.toString()

        data[position].desc?.let {
            viewHolder.repoDesc.text = data[position].desc
        }?: run {
            viewHolder.repoDesc.text = "NO DESC"
            viewHolder.repoDesc.setTextColor(Color.RED)
        }

        //eu criei esse
        data[position].lang?.let {
            viewHolder.repoLang.text = data[position].lang
        }?:run {
            viewHolder.repoLang.text = "NO LANG"
            viewHolder.repoLang.setTextColor(Color.RED)
        }

    }

    public fun addRepos(repos:ArrayList<Repo>){
        data.addAll(repos)
        notifyDataSetChanged()
    }

    class StarRepoViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val repoName = view.repoName
        val repoDesc = view.desc
        val repoLang = view.lang
        val repoStarsCount = view.starsCount
    }
}