package com.manucg.pruebaroom_n_m.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="alumno")
data class Alumno(
    @ColumnInfo(name = "nombre")
    var nombre : String,
    @ColumnInfo(name="edad")
    var edad : Int
){

    @ColumnInfo(name="idAlumno")
    @PrimaryKey(autoGenerate = true)
    var idAlumno : Int= 0

}
