package com.manucg.pruebaroom_n_m.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.manucg.pruebaroom_n_m.entidades.Matricula

@Dao
interface InterfaceDaoMatricula {

    @Insert
    fun addMatricula(matricula: Matricula)

    @Query("SELECT a.nombre || '[' || c.nivel || c.nombre || ']' FROM matricula m JOIN alumno a ON m.alumnoId = a.idAlumno JOIN curso c ON m.cursoId = c.idCurso")
    fun getMatriculas(): MutableList<String>

    @Query("SELECT a.nombre || '[' || c.nivel || c.nombre || ']' FROM matricula m JOIN alumno a ON m.alumnoId = a.idAlumno JOIN curso c ON m.cursoId = c.idCurso WHERE a.idAlumno = :alumnoId")
    fun getMatriculasByAlumno(alumnoId: Int): MutableList<String>

    @Query("SELECT a.nombre || '[' || c.nivel || c.nombre || ']' FROM matricula m JOIN alumno a ON m.alumnoId = a.idAlumno JOIN curso c ON m.cursoId = c.idCurso WHERE c.idCurso = :cursoId")
    fun getMatriculasByCurso(cursoId: Int): MutableList<String>

    @Delete
    fun deleteMatricula(matricula: Matricula)

    @Query("DELETE FROM matricula")
    fun limpiaTablaMatricula()
}