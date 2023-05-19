package com.example.inventory.data

import androidx.constraintlayout.helper.widget.Flow
import androidx.room.*

@Dao
interface ItemDao {

    @Query("SELECT * from item WHERE id = :id")
    fun getItem(id: Int): kotlinx.coroutines.flow.Flow<Item>

    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): kotlinx.coroutines.flow.Flow<List<Item>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)
}