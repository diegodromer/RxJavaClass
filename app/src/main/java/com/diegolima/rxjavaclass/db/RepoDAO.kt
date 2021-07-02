package com.diegolima.rxjavaclass.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable

@Dao
interface RepoDAO {
    @Query(" SELECT * FROM repo")
    fun fetchAllMyStarsRepo():ArrayList<Repo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllMyStarsRepos(repos: List<Repo>)

}