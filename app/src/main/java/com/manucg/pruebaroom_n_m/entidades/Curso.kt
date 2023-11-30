package com.manucg.pruebaroom_n_m.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="curso")
data class Curso(
    @ColumnInfo(name="nivel")
    var edad : Int,
    @ColumnInfo(name = "nombre")
    var nombre : String
){

    @ColumnInfo(name="idCurso")
    @PrimaryKey(autoGenerate = true)
    var idCurso : Int= 0

}