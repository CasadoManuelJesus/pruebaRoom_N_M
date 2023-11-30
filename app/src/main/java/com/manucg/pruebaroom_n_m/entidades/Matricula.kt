package com.manucg.pruebaroom_n_m.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "matricula",
    primaryKeys = ["alumnoId", "cursoId"],
    foreignKeys = [
        ForeignKey(
            entity =
            Alumno::class,
            parentColumns = ["idAlumno"],
            childColumns = ["alumnoId"]
        ),
        ForeignKey(
            entity = Curso::class,
            parentColumns = ["idAlumno"],
            childColumns = ["recetaId"]
        )
    ]
)
data class Matricula(
    @ColumnInfo(name = "alumnoId")
    var alumnoId: Int = 0,
    @ColumnInfo(name = "cursoId")
    var cursoId: Int = 0
){

}
