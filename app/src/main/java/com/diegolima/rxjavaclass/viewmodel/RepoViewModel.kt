package com.diegolima.rxjavaclass.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diegolima.rxjavaclass.db.Repo
import com.diegolima.rxjavaclass.repository.RepoLocalSource
import com.diegolima.rxjavaclass.repository.RepoRemoteSource
import com.diegolima.rxjavaclass.repository.RepoRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RepoViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()
    val repoLiveData = MutableLiveData<ArrayList<Repo>>()
    val repository = RepoRepository(RepoRemoteSource, RepoLocalSource)


    fun getMyStarsRepos(username: String) {

        val repoDisposable = repository.fetchRepos(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it -> repoLiveData.value = it
            }

        compositeDisposable.add(repoDisposable)
    }

    fun getLiveData(): LiveData<ArrayList<Repo>> = repoLiveData

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}