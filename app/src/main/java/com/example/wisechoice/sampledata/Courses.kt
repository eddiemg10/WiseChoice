package com.example.wisechoice.sampledata

import com.example.wisechoice.*

object CoursesData{

    val explore = listOf(

        Course(
            id = 1,
            name = "Bsc Industrial Chemistry",
            university = "6 Universities",
            star = "11.2K",
            pic = "https://pioneer4ss.com/wp-content/uploads/2021/08/Industrial-Chemistry.jpg"
        ),
        Course(
            id = 8,
            name = "BA Music",
            university = "6 Universities",
            star = "617",
            pic = "https://images.pexels.com/photos/7095719/pexels-photo-7095719.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        Course(
            id = 2,
            name = "Bsc Computer Science",
            university = "15 Universities",
            star = "3.3K",
            pic = "https://storage-prtl-co.imgix.net/endor/articles/434/images/1663928047_shutterstock_2083362643.jpg?max-w=660&max-h=532&fit=crop&auto=format,compress&q=40"
        ),
        Course(
            id = 3,
            name = "Bachelor of Law (L.L.B)",
            university = "6 Universities",
            star = "11.2K",
            pic = "https://cdn.britannica.com/51/190451-050-0E9B50F5/soundblock-Wood-scales-books-stack-background-leather.jpg"
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
            pic = "https://www.aud.edu/media/0fii5di3/shutterstock_1021965007_schiool-of-business-administration_economics_option2.jpg"
        ),
        Course(
            id = 7,
            name = "BA Fine Art",
            university = "3 Universities",
            star = "1.0K",
            pic = "https://images.pexels.com/photos/262034/pexels-photo-262034.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        Course(
            id = 8,
            name = "Bsc Marine Science",
            university = "12 Universities",
            star = "67",
            pic = "https://www.oceandecade.org/wp-content/uploads/2021/09/30.-Marine.Science-2-Credit-Bertarelli-Foundation-Emma-Levy.jpg"
        ),
        Course(
            id = 3,
            name = "B Hospitality Management",
            university = "6 Universities",
            star = "90",
            pic = "https://keystoneacademic-res.cloudinary.com/image/upload/f_auto,q_auto,c_fill,w_1920/element/13/138508_EMlyonhospHL.jpg"
        ),
    )

    val starred = listOf(

        Course(
            id = 1,
            name = "Bsc Environmental Science",
            university = "6 Universities",
            star = "26/11/2022",
            pic = "https://collegerealitycheck.com/wp-content/uploads/environmental-science-1932365063-1024x768.jpg"
        ),
        Course(
            id = 2,
            name = "BA Psychology",
            university = "15 Universities",
            star = "21/11/2022",
            pic = "https://pacifichealthsystems.com/wp-content/uploads/2020/11/Psychologist-san-diego.jpg"
        ),
        Course(
            id = 3,
            name = "B Hospitality Management",
            university = "6 Universities",
            star = "24/11/2022",
            pic = "https://keystoneacademic-res.cloudinary.com/image/upload/f_auto,q_auto,c_fill,w_1920/element/13/138508_EMlyonhospHL.jpg"
        ),
        Course(
            id = 4,
            name = "Bsc Actuarial Science",
            university = "12 Universities",
            star = "1/11/2022",
            pic = "https://cdn.uconnectlabs.com/wp-content/uploads/sites/122/2021/07/actuarial-science.jpg"
        ),
        Course(
            id = 5,
            name = "BA Religious Studies",
            university = "3 Universities",
            star = "16/10/2022",
            pic = "https://images.pexels.com/photos/267559/pexels-photo-267559.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        Course(
            id = 6,
            name = "Bsc Zoology",
            university = "25 Universities",
            star = "16/10/2022",
            pic = "https://images.pexels.com/photos/3992430/pexels-photo-3992430.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),

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

    val personality = listOf(

        HollandCourse(
            hollandCode = Holland("RIA", "Realistic (R), Investigative (I), Artistic (A)"),
            match = 5,
            label = "Strongest match",
            listOf(
                Course(
                    id = 1,
                    name = "Bsc Mechanical Engineering",
                    university = "4 Universities",
                    star = "23.2K",
                    pic = "https://www.bolton.ac.uk/assets/Uploads/shutterstock-1213477993-2.jpg"
                ),
            )
        ),

        HollandCourse(
            hollandCode = Holland("RI", "Realistic (R), Investigative (I)"),
            match = 3,
            label = "2nd Strongest match",
            listOf(
                Course(
                    id = 2,
                    name = "BA Education",
                    university = "15 Universities",
                    star = "3.3K",
                    pic = "https://images.pexels.com/photos/935943/pexels-photo-935943.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                ),
                Course(
                    id = 1,
                    name = "Bsc Economics & Statistics",
                    university = "7 Universities",
                    star = "12.2K",
                    pic = "https://images.pexels.com/photos/3970330/pexels-photo-3970330.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                ),
                Course(
                    id = 3,
                    name = "Bsc Comp Security & Forensics",
                    university = "3 Universities",
                    star = "903",
                    pic = "https://www.phoenix.edu/blog/what-is-computer-forensics/_jcr_content/root/responsivegrid/section/resource/columns/responsivegrid0/image.coreimg.jpeg/1663090528536/computer-forensics-professional-taking-notes-704x421.jpeg"
                ),
                Course(
                    id = 4,
                    name = "Bsc Actuarial Science",
                    university = "12 Universities",
                    star = "3.2K",
                    pic = "https://cdn.uconnectlabs.com/wp-content/uploads/sites/122/2021/07/actuarial-science.jpg"
                ),
            )
        ),
        HollandCourse(
            hollandCode = Holland("R", "Realistic (R)"),
            match = 1,
            label = "3rd Strongest match",
            listOf(
                Course(
                    id = 2,
                    name = "BA Education",
                    university = "15 Universities",
                    star = "3.3K",
                    pic = "https://images.pexels.com/photos/935943/pexels-photo-935943.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                ),
                Course(
                    id = 6,
                    name = "Ba Political Science",
                    university = "11 Universities",
                    star = "189",
                    pic = "https://www.umgc.edu/online-degrees/bachelors/political-science/_jcr_content/root/main-par/statistics-block/image.coreimg.82.1280.jpeg/1655143058524/bachelors-political-science-secondary-shutterstock-1614290143.jpeg"
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
                    name = "Bsc Accounting",
                    university = "12 Universities",
                    star = "679",
                    pic = "https://www.deskera.com/blog/content/images/2020/11/featured-image-1.jpg"
                )
            )
        ),

    )

    val results = listOf(

        Course(
            id = 1,
            name = "Bsc Software Engineering",
            university = "6 Universities",
            star = "11.2K",
            pic = "https://images.pexels.com/photos/546819/pexels-photo-546819.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        Course(
            id = 2,
            name = "Bsc Computer Science",
            university = "9 Universities",
            star = "3.3K",
            pic = "https://storage-prtl-co.imgix.net/endor/articles/434/images/1663928047_shutterstock_2083362643.jpg?max-w=660&max-h=532&fit=crop&auto=format,compress&q=40"
        ),
        Course(
            id = 3,
            name = "BA Linguistics",
            university = "6 Universities",
            star = "11.2K",
            pic = "https://images.pexels.com/photos/159581/dictionary-reference-book-learning-meaning-159581.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
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
            name = "Bsc Communication",
            university = "25 Universities",
            star = "311",
            pic = "https://images.pexels.com/photos/4331578/pexels-photo-4331578.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
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
            name = "BA Music",
            university = "6 Universities",
            star = "617",
            pic = "https://images.pexels.com/photos/7095719/pexels-photo-7095719.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        )
    )



}