package com.manucg.pruebaroom_n_m.conexiones

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.manucg.pruebaroom_n_m.entidades.Alumno
import com.manucg.pruebaroom_n_m.entidades.Curso
import com.manucg.pruebaroom_n_m.entidades.Matricula
import com.manucg.pruebaroom_n_m.interfaces.InterfaceDaoAlumno
import com.manucg.pruebaroom_n_m.interfaces.InterfaceDaoCurso
import com.manucg.pruebaroom_n_m.interfaces.InterfaceDaoMatricula

// Esta anotación define la base de datos utilizando Room.
// Cambio la versión a 2 debido a la migración
@Database(entities = [Alumno::class, Curso::class, Matricula::class], version = 1)
abstract class RoomDB : RoomDatabase() {

    // Este método abstracto proporciona acceso al DAO
    abstract fun DaoAlumno(): InterfaceDaoAlumno

    //Acceso al DAO de curso
    abstract fun DaoCurso(): InterfaceDaoCurso

    //Acceso al DAO de Matricula
    abstract fun DaoMatricula(): InterfaceDaoMatricula

    // Este bloque define un companion object que contiene métodos estáticos.

    companion object {
        // INSTANCE almacena la instancia única de la base de datos.
        private var INSTANCE: RoomDB? = null

        // Este método estático crea y devuelve la instancia de la base de datos utilizando Room.
        fun getBaseDatos(context: Context): RoomDB {
            // Si INSTANCE es nulo, crea una nueva instancia de la base de datos.
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext, RoomDB::class.java,
                    // Se especifica el nombre de la base de datos como "usuariosBD".
                    "matriculasBD"
                )
                    // Permite realizar consultas en el hilo principal
                    .allowMainThreadQueries()
                    .build()
            }
            // Devuelve la instancia existente o recién creada de la base de datos.
            return INSTANCE as RoomDB
        }
    }
}
