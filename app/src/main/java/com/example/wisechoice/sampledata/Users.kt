package com.example.wisechoice.sampledata

import com.example.wisechoice.Grades
import com.example.wisechoice.User

object UsersData {

    val user1 = User(
        id = "001",
        fname = "John",
        lname = "Doe",
        email = "johndoe@example.com",
        holland = "RIA",
        grades = Grades(
            "A",
            "A",
            "B",
            "A-",
            "B+",
            "A",
            "A"

        )
    )
}
