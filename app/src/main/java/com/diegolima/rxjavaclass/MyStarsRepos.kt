package com.diegolima.rxjavaclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.diegolima.rxjavaclass.adapter.GithubRepoAdapter
import com.diegolima.rxjavaclass.db.Repo
import com.diegolima.rxjavaclass.viewmodel.RepoViewModel
import kotlinx.android.synthetic.main.activity_my_stars_repos.*

class MyStarsRepos : AppCompatActivity() {

    val repoList = ArrayList<Repo>()
    private lateinit var repoAdapter: GithubRepoAdapter
    private lateinit var repoViewModel: RepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_stars_repos)

        val linearLayoutmg = LinearLayoutManager(applicationContext)
        val divider = DividerItemDecoration(myStarsList.context, DividerItemDecoration.VERTICAL) //serve para traçar uma linha entre cada recyclerView
        myStarsList.layoutManager = linearLayoutmg
        repoAdapter = GithubRepoAdapter()
        myStarsList.adapter = repoAdapter
        myStarsList.addItemDecoration(divider)

        repoViewModel = ViewModelProvider(this).get(RepoViewModel::class.java)

        getStarredRepos(repoViewModel)
        observeMyStars(repoViewModel)
    }

    fun getStarredRepos(viewModel: RepoViewModel) {
        viewModel.getMyStarsRepos("mrabelwahed")
    }

    fun observeMyStars(viewModel: RepoViewModel){
        viewModel.getLiveData().observe(this, Observer {
                repos -> repoAdapter.addRepos(repos!!)
        })
    }

}