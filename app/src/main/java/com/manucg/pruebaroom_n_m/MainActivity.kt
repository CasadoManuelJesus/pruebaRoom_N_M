package com.manucg.pruebaroom_n_m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.manucg.pruebaroom_n_m.conexiones.RoomDB
import com.manucg.pruebaroom_n_m.entidades.Alumno
import com.manucg.pruebaroom_n_m.entidades.Curso
import com.manucg.pruebaroom_n_m.entidades.Matricula
import com.manucg.pruebaroom_n_m.interfaces.InterfaceDaoAlumno
import com.manucg.pruebaroom_n_m.interfaces.InterfaceDaoCurso
import com.manucg.pruebaroom_n_m.interfaces.InterfaceDaoMatricula

class MainActivity : AppCompatActivity() {
    lateinit var conexion : RoomDB
    lateinit var daoAlumno: InterfaceDaoAlumno
    lateinit var daoCurso: InterfaceDaoCurso
    lateinit var daoMatricula: InterfaceDaoMatricula

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()

        /* INFO IMPORTANTE
        * 1. SORRY POR LOS ERRORES EN LA EDAD DE LA GENTE PERO LA VERDAD QUE HE PUESTO LA PRIMERA QUE SE ME HA VENIDO EN LA MENTE
        * 2. HE PERSONALIZADO LAS CONSULTAS DE INTERFACEDAOMATRICULA PARA QUE ME DEVUELVA UN STRING AL IGUAL QUE HACIAMOS CON PAPÁ (PABLO PARA QUIÉN NO SEPA DE LORE DE 1º)
        * 3. JULIÁN ME VENIAS PERFECTO PARA EL BORRADO DE LAS MATRICULAS, TQM
        * 4. ESTÁ HECHO CON LA FINALIDAD DE QUE OS AYUDE Y SI NECESITAIS CUALQUIER COSITA MD
        * 5. VAMOS QUE SE PUEDE CARAJOOOOOOOOOO
        */

        borrarTablas()
        pruebaAlumno()
        pruebaCurso()
        pruebaMatricula()
        borrarTablas()
    }

    fun setup(){
        conexion= RoomDB.getBaseDatos(this)
        daoAlumno=conexion.DaoAlumno()
        daoCurso=conexion.DaoCurso()
        daoMatricula=conexion.DaoMatricula()
    }

    fun pruebaAlumno(){
        /*AÑADIENDO ALUMNOS*/
        daoAlumno.addAlumno(Alumno("Manuel Jesús Casado", 23))
        daoAlumno.addAlumno(Alumno("Pablo Arenas", 19))
        daoAlumno.addAlumno(Alumno("Julián Garrido", 21))
        daoAlumno.addAlumno(Alumno("Ana Campos", 29))
        daoAlumno.addAlumno(Alumno("Manuel Alejandro Nuñez", 30))
        daoAlumno.addAlumno(Alumno("Daniel Llamas", 25))
        daoAlumno.addAlumno(Alumno("Óscar Clavijo", 20))
        daoAlumno.addAlumno(Alumno("Antonio Jiménez", 23))
        daoAlumno.addAlumno(Alumno("Ana Camacho", 25))
        daoAlumno.addAlumno(Alumno("Jorge Galán", 20))

        /*OBTENIENDO ALUMNOS*/
        daoAlumno.getAlumnos().forEach{
            Log.d("getAlumnos()",it.toString())
        }

        /*OBTENIENDO UN ALUMNO*/
        Log.d("getAlumno()", daoAlumno.getAlumno("Manuel Jesús Casado").toString())

        /*ACTUALIZANDO ALUMNO*/
        var alumnoActualizado = daoAlumno.getAlumno("Manuel Jesús Casado")
        alumnoActualizado.nombre="Manu Casado"
        daoAlumno.updateAlumno(alumnoActualizado)
        Log.d("updateAlumno()", daoAlumno.getAlumno("Manu Casado").toString())

        /*BORRANDO ALUMNO*/
        daoAlumno.addAlumno(Alumno("Alumno con poca esperanza de vida", 0))
        Log.d("Antes de eliminar", daoAlumno.getAlumno("Alumno con poca esperanza de vida").toString())
        daoAlumno.deleteAlumno(daoAlumno.getAlumno("Alumno con poca esperanza de vida"))
        daoAlumno.getAlumnos().forEach{
            Log.d("Despues de eliminar",it.toString())
        }
    }

    fun pruebaCurso(){
        /*AÑADIENDO CURSOS*/
        daoCurso.addCurso(Curso(1, "DAM"))
        daoCurso.addCurso(Curso(2, "DAMN"))
        daoCurso.addCurso(Curso(1, "ASIR"))

        /*OBTENIENDO CURSOS*/
        daoCurso.getCursos().forEach {
            Log.d("getCursos()", it.toString())
        }

        /*OBTENIENDO UN CURSO*/
        daoCurso.getCurso(1, "DAM")

        /*ACTUALIZANDO CURSO*/
        var cursoActualizado=daoCurso.getCurso(2, "DAMN")
        cursoActualizado.nombre="DAM"
        daoCurso.updateCurso(cursoActualizado)
        Log.d("updateCurso()", daoCurso.getCurso(2, "DAM").toString())

        /*BORRANDO CURSO*/
        daoCurso.addCurso(Curso(1, "Curso que no quiere nadie"))
        Log.d("Antes de eliminar", daoCurso.getCurso(1, "Curso que no quiere nadie").toString())
        daoCurso.deleteCurso(daoCurso.getCurso(1, "Curso que no quiere nadie"))
        daoCurso.getCursos().forEach {
            Log.d("Despues de eliminar", it.toString())
        }
    }

    fun pruebaMatricula(){
        /*AÑADIENDO MATRICULAS*/

        daoMatricula.addMatricula(Matricula(daoAlumno.getAlumno("Manu Casado").idAlumno,daoCurso.getCurso(2, "DAM").idCurso))
        daoMatricula.addMatricula(Matricula(daoAlumno.getAlumno("Pablo Arenas").idAlumno,daoCurso.getCurso(2, "DAM").idCurso))
        daoMatricula.addMatricula(Matricula(daoAlumno.getAlumno("Julián Garrido").idAlumno,daoCurso.getCurso(2, "DAM").idCurso))
        daoMatricula.addMatricula(Matricula(daoAlumno.getAlumno("Julián Garrido").idAlumno,daoCurso.getCurso(1, "ASIR").idCurso))
        daoMatricula.addMatricula(Matricula(daoAlumno.getAlumno("Ana Campos").idAlumno,daoCurso.getCurso(2, "DAM").idCurso))
        daoMatricula.addMatricula(Matricula(daoAlumno.getAlumno("Manuel Alejandro Nuñez").idAlumno,daoCurso.getCurso(2, "DAM").idCurso))
        daoMatricula.addMatricula(Matricula(daoAlumno.getAlumno("Daniel LLamas").idAlumno,daoCurso.getCurso(2, "DAM").idCurso))
        daoMatricula.addMatricula(Matricula(daoAlumno.getAlumno("Óscar Clavijo").idAlumno,daoCurso.getCurso(2, "DAM").idCurso))
        daoMatricula.addMatricula(Matricula(daoAlumno.getAlumno("Antonio Jiménez").idAlumno,daoCurso.getCurso(2, "DAM").idCurso))
        daoMatricula.addMatricula(Matricula(daoAlumno.getAlumno("Ana Camacho").idAlumno,daoCurso.getCurso(1, "DAM").idCurso))
        daoMatricula.addMatricula(Matricula(daoAlumno.getAlumno("Ana Camacho").idAlumno,daoCurso.getCurso(2, "DAM").idCurso))
        daoMatricula.addMatricula(Matricula(daoAlumno.getAlumno("Jorge Galán").idAlumno,daoCurso.getCurso(1, "DAM").idCurso))

        /*OBTENIENDO LAS MATRICULAS*/
        daoMatricula.getMatriculas().forEach {
            Log.d("getMatriculas()",it)
        }

        /*OBTENIENDO LAS MATRICULAS DE UN ALUMNO*/
        daoMatricula.getMatriculasByAlumno(daoAlumno.getAlumno("Julián Garrido").idAlumno).forEach {
            Log.d("Obteniendo matriculas de Julián", it)
        }

        /*OBTENIENDO LAS MATRICULAS DE UN CURSO*/
        daoMatricula.getMatriculasByCurso(daoCurso.getCurso(2,"DAM").idCurso).forEach {
            Log.d("Matriculas de 2 DAM", it)
        }

        /*BORRANDO MATRICULA*/
        daoMatricula.deleteMatricula(Matricula(daoAlumno.getAlumno("Julián Garrido").idAlumno,daoCurso.getCurso(1,"ASIR").idCurso))
        daoMatricula.getMatriculas().forEach {
            Log.d("Julián deja ASIR para pertenecer a la best clase on the world", it)
        }
    }

    fun borrarTablas(){
        daoMatricula.limpiaTablaMatricula()
        daoCurso.limpiaTablaCurso()
        daoAlumno.limpiaTablaAlumno()
    }
}