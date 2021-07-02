package com.diegolima.rxjavaclass.repository

import com.diegolima.rxjavaclass.db.Repo
import io.reactivex.Observable

class RepoRepository(val repoRemoteSource: RepoRemoteSource, val repoLocalSource: RepoLocalSource) :
    RepoDataSource {

    override fun fetchRepos(username: String): Observable<ArrayList<Repo>> {
        return Observable.concatArray(
            repoLocalSource.fetchRepos(username),
            repoRemoteSource.fetchRepos(username)
        )
            .doOnNext { repos ->
                saveRepos(repos)
            }
            //.onErrorResumeNext(Observable.empty())
    }

    override fun saveRepos(repos: ArrayList<Repo>) {
        Observable.fromCallable { repoLocalSource.saveRepos(repos) }
    }

}