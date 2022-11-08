package com.example.wisechoice.sampledata

import com.example.wisechoice.Course
import com.example.wisechoice.Cutoff
import com.example.wisechoice.University

object CoursesData{

    val explore = listOf(

        Course(
            id = 1,
            name = "Bsc Industrial Chemistry",
            university = "6 Universities",
            star = "11.2K",
            pic = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
        ),
        Course(
            id = 2,
            name = "Bsc Computer Science",
            university = "15 Universities",
            star = "3.3K",
            pic = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
        ),
        Course(
            id = 3,
            name = "Bachelor of Law (L.L.B)",
            university = "6 Universities",
            star = "11.2K",
            pic = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
        ),
        Course(
            id = 4,
            name = "Bsc Actuarial Science",
            university = "12 Universities",
            star = "3.2K",
            pic = "https://cdn.uconnectlabs.com/wp-content/uploads/sites/122/2021/07/actuarial-science.jpg"
        ),
        Course(
            id = 5,
            name = "Bsc Chemical Engineering",
            university = "3 Universities",
            star = "1.2K",
            pic = "https://eece.wustl.edu/images/Chemical-engineering-major.jpg"
        ),
        Course(
            id = 6,
            name = "Ba Economics",
            university = "25 Universities",
            star = "3.3K",
            pic = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
        ),
        Course(
            id = 7,
            name = "Bachelor of Education",
            university = "16 Universities",
            star = "8.2K",
            pic = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
        ),
        Course(
            id = 8,
            name = "Bsc Marine Science",
            university = "12 Universities",
            star = "67",
            pic = ""
        )
    )

    val filtered = listOf(

        University(
            id = 1,
            name = "Strathmore University",
            logo = "https://res.cloudinary.com/crunchbase-production/image/upload/c_lpad,f_auto,q_auto:eco,dpr_1/v1421163184/yifuopsilbj2okuodbpy.jpg",
            cutoff = arrayOf(
                    Cutoff(
                        year = 2021,
                        cutoff = 22.926f
                    ),
                    Cutoff(
                        year = 2020,
                        cutoff = 21.926f
                    )
                )
        ),

        University(
            id = 2,
            name = "Daystar University",
            logo = "https://www.daystar.ac.ke/images/logo.png",
            cutoff = arrayOf(
                Cutoff(
                    year = 2021,
                    cutoff = 20.96f
                )
            )
        ),
        University(
            id = 2,
            name = "University of Nairobi",
            logo = "https://www.uonbi.ac.ke/sites/default/files/UoN%20Logo_0.jpg",
            cutoff = arrayOf(
                Cutoff(
                    year = 2021,
                    cutoff = 22.96f
                ),
                Cutoff(
                    year = 2020,
                    cutoff = 21.426f
                )
            )
        ),
    )

}