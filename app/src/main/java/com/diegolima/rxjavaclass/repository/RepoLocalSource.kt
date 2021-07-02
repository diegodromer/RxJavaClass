package com.diegolima.rxjavaclass.repository

import com.diegolima.rxjavaclass.RxApp
import com.diegolima.rxjavaclass.db.AppDatabase
import com.diegolima.rxjavaclass.db.Repo
import io.reactivex.Observable

object RepoLocalSource : RepoDataSource{

    override fun fetchRepos(username: String): Observable<ArrayList<Repo>> {
        return Observable.fromCallable {
            AppDatabase.getInstance(RxApp.INSTANCE)?.getRepoDao()!!.fetchAllMyStarsRepo() //as ArrayList<Repo>?
        }
    }

    override fun saveRepos(repos: ArrayList<Repo>) {
        AppDatabase.getInstance(RxApp.INSTANCE)?.getRepoDao()!!.saveAllMyStarsRepos(repos)
    }

}
