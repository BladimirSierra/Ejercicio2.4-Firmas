package com.example.ejercicio24_firmas.transacciones;

public class Transacciones {

    /*TABLA*/
    public static final String tabla_firmas = "Firmas";


    // Campos de la base de datos
    public static final String id = "id";
    public static final String image = "image";
    public static final String descripcion = "descripcion";


    // CRUD (Create - Delete)
    public static final String CreateTableFirmas= "CREATE TABLE Firmas" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "image BLOB, " +
            "descripcion TEXT)";

    public static final String DropTableFirmas= "DROP TABLE IF EXISTS Firmas";


    // Creacion del nombre de la base de datos
    public static final String NameDataBase = "Tarea4FirmasBladimir";
}
