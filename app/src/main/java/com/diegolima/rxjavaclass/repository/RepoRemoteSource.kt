package com.diegolima.rxjavaclass.repository

import com.diegolima.rxjavaclass.db.Repo
import com.diegolima.rxjavaclass.network.GithubApiClient
import io.reactivex.Observable

object RepoRemoteSource : RepoDataSource{
    override fun fetchRepos(username: String): Observable<ArrayList<Repo>> {
        return GithubApiClient.getGithubService().getStarredRepo(username)
    }

    override fun saveRepos(repos: ArrayList<Repo>) {

    }

}
