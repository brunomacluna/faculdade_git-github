package com.example.aula09;

import androidx.room.Dao;
import androidx.room.Insert;
@Dao
public interface ContatoDAO {
    @Insert
     void insertContato(Contato contato);

}
