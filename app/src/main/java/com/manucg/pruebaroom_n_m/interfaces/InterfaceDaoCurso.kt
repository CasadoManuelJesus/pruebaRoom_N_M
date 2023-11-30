package com.manucg.pruebaroom_n_m.interfaces

import androidx.room.*
import com.manucg.pruebaroom_n_m.entidades.Curso

@Dao
interface InterfaceDaoCurso {
    @Insert
    fun addCurso(curso : Curso)

    @Query("SELECT * FROM curso")
    fun getCursos() : MutableList<Curso>

    @Query("SELECT * FROM curso WHERE nombre LIKE :nombre AND nivel LIKE :nivel")
    fun getCurso(nivel:Int, nombre: String) : Curso

    @Update
    fun updateCurso(curso : Curso)

    @Delete
    fun deleteCurso(curso: Curso)

    @Query("DELETE FROM curso")
    fun limpiaTablaCurso()
}