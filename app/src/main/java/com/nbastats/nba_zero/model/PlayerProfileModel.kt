package com.nbastats.nba_zero.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class PlayerProfileModel(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val team: String,
    val position: String,
    val dateOfBirth: String,
    val height: String,
    val weight: String,
    val jerseyNumber: String,
    val age: String,

    val careerPoints: Float,
    val careerBlocks: Float,
    val carrerAssists: Float,
    val careerRebounds: Float,
    val careerTurnovers: Float,
    val careerPercentageThree: Float,
    val careerPercentageFreethrow: Float,
    val careerPercentageFieldGoal: Float,

    val headShotUrl: String,
    val dateLastUpdated: String

)