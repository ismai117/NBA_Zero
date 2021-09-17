package com.nbastats.nba_zero.network

import com.nbastats.nba_zero.model.PlayerProfileModel
import com.nbastats.nba_zero.model.PlayerSeasonModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface PlayerService {

    @GET("players/fullname?")
    suspend fun playerProfile(
        @Header("x-rapidapi-host") host: String,
        @Header("x-rapidapi-key") key: String,
        @Query("name") name: String
    ): PlayerProfileModel

    @GET("player/playerseasons?")
    suspend fun playerSeason(
        @Header("x-rapidapi-host") host: String,
        @Header("x-rapidapi-key") key: String,
        @Query("playerid") id: Int
    ): PlayerSeasonModel


}