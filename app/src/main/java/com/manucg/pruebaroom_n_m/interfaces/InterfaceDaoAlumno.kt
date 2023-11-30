package com.manucg.pruebaroom_n_m.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.manucg.pruebaroom_n_m.entidades.Alumno

@Dao
interface InterfaceDaoAlumno {

        @Insert
        fun addAlumno(alumno : Alumno)

        @Query("SELECT * FROM alumno")
        fun getAlumnos() : MutableList<Alumno>

        @Query("SELECT * FROM alumno WHERE nombre LIKE :nombre")
        fun getAlumno(nombre: String) : Alumno

        @Update
        fun updateAlumno(alumno : Alumno)

        @Delete
        fun deleteAlumno(alumno:Alumno)

        @Query("DELETE FROM alumno")
        fun limpiaTablaAlumno()

}