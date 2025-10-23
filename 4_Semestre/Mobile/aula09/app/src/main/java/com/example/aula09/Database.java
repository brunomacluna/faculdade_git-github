package com.example.aula09;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = Contato.class, version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract ContatoDAO contatoDAO();
}
