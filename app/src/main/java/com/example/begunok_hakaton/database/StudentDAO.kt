package com.example.begunok_hakaton.database

import androidx.room.Query
import com.example.begunok_hakaton.dataclasses.StudentDataClasses.Lesson

interface StudentDAO {
    @Query("SELECT lesson_list FROM Student")
    suspend fun getLessons(): ArrayList<Lesson>
}