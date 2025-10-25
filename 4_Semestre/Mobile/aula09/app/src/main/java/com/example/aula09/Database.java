package com.example.aula09;

import androidx.room.RoomDatabase;
@androidx.room.Database(entities = Contato.class, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract ContatoDAO contatoDAO();

}