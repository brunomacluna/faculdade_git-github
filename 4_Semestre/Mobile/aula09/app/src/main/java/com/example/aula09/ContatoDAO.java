package com.example.aula09;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContatoDAO {
    @Insert
    void insertContato(Contato contato);
    @Delete
    void deleteContato(Contato contato);
    @Update
    void updateContato(Contato contato);
    @Query("select * from contatos")
    List<Contato> getAllContatos();



}//ContatoDAO
