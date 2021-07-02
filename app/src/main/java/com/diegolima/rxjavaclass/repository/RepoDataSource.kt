package com.diegolima.rxjavaclass.repository

import com.diegolima.rxjavaclass.db.Repo
import io.reactivex.Observable

interface RepoDataSource {
    fun fetchRepos(username:String): Observable<ArrayList<Repo>>
    fun saveRepos(repos:ArrayList<Repo>)
}