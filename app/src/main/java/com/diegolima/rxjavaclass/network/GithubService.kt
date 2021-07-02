package com.diegolima.rxjavaclass.network

import com.diegolima.rxjavaclass.db.Repo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import kotlin.collections.ArrayList

interface GithubService {

    @GET("users/{user}/starred")
    fun getStarredRepo(@Path("user") username:String): Observable<ArrayList<Repo>>

}