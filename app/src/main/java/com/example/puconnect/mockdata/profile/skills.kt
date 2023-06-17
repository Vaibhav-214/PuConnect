package com.example.puconnect.mockdata.profile


val webAndMobile = listOf("Flutter", "React Js", "HTML", "CSS", "Android Developer", "Wordpress", "Angular JS", "IOS Developer", "Fronteend Developer", "Next.js", "Full Stack Web Development", "MERN Stack", "Lavarel", "Firebase", "Tailwind CSS", "SCSS","Vue js", "Wix", "Redux", "Ecommerce Website", "App Development")

val tech = listOf("Node JS", "Mongo DB", "Cloud Computing", "Python", "Artificial Intelligence", "Machine Learning", "Java", "C++", "C", "Github", "AWS", "NoSQL", "SQL", "Django", "Spring", "Software Testing", "Software Architecture","C#", "Cyber Security", "Data Science", "NLP", "SaaS", "Blockchain Development", "DevOps", "Salesforce Development", "php", "Competitive Programming", "MySQL", "Computer Science", "Embedded Systems", "Game Development", "Spring Boot", "Docker", "TypeScript", "Web 3","PostgreSQL", "Solidity", "Database Management", "Biotechnology", "Data Cleaning", "Deep Learning","Tensorflow", "Web Scraping", "Kubernetes", "Data Structures and Algorithms", "Linux", "Jupyter Notebook", "IT Support", "Software Development Engineering", "Object Oriented Programming", "Information Technology", "Rest API", "Express.js", "IoT")

val design = listOf("Fashion Design", "Graphic Design", "Illustrator", "Photoshop", "Canva", "After Effects", "Figma","Adobe XD", "Webflow", "Interaction", "Game Design", "UX Research", "UI Designing", "UX Design","Product Designing","Blender 3d","SketchUP", "Revit","Lumion","UI/UX", "Unreal Engine", "SOLIDWORKS", "Maya", "Logo Designer", "Lightroom", "Fusion 360", "CoreIDRAW", "YouTube Thumbnail", "Vray", "Wireframing", "Adobe Indesign","Caraldraw", "Prototyping","Fashion Illustration","Rhinoceros 3D", "Poster Designing","Flyer Design" )

val marketing = listOf("Content Writing", "Copy Writing", "Social Media Management", "Facebook Ads", "Google Ads", "Influencer Marketing","SEO","Digital Marketing","Content Creation","Digital Media Management","Email Marketing","Marketing","Performance Marketing", "Brand Strategy", "Affiliate Marketing", "Social Media Marketing","Instagram Ads","Public Relations", "Social Media Analyst","Instagram Page Manager", "Product Marketing", "Youtube Channel Manager", "Content Marketing" )

val videoEditing = listOf("Premiere Pro", "Final Cut Pro", "iMovie", "Motion Graphics", "Video Editing", "Photography","Davinci Resolve", "Instagram Reels","Videography", "Photo Editing", "Audio Editing","Youtube Video", "Filmmaking","Cinematography","Voice Over","VN")

val product = listOf("Data Analysis", "Psychology","Entrepreneurship","Problem Solving","Microsoft Word","Google Analytics","Product Growth","Tableau","Product Description Writing","Program Management","MS Powerpoint","Product Strategy","Interpersonal Skills")

val writing = listOf("Script Writing","Typing", "Scientific Writing", "Poetry","Article Writing","Creative Writing","Academic Writing","Copy typing","SEO Optimized Writing")

val business = listOf("Public Speaking", "Stock Market", "Finance","Business Strategy","Trading","Leadership","Equity Research","Statistics","Investment","Shopify", "Business Development","Law","Business Analytics", "Management","Financial Management", "PowerPoint","MS Office","MS Excel","Technical Analysis","Economics", "Fundamental Analysis","Communicative English","Team Building","Options Trading","Risk Management","Time Management","HR Operations","Power BI","Strategic Management","Investment Banking","Team Management","Financial Statement Analysis","Data Analytics","Market Research","Human Research Management")

val sales = listOf("Event Management", "Data Entry","Telecalling","Sales","Operations Management","CRM","Virual Assistant","Telesales","Customer Service","Translation")


data class GenreWithSkills(
    val genre: String,
    val skillList: List<String>
)

val allGenres = listOf(
    GenreWithSkills(
        genre = "Web & Mobile Development",
        skillList = webAndMobile
    ),
    GenreWithSkills(
        genre = "Tech",
        skillList = tech
    ),
    GenreWithSkills(
        genre = "Design",
        skillList = design
    ),
    GenreWithSkills(
        genre = "Marketing",
        skillList = marketing
    ),
    GenreWithSkills(
        genre = "Video Editing",
        skillList = videoEditing
    ),
    GenreWithSkills(
        genre = "Product",
        skillList = product
    ),
    GenreWithSkills(
        genre = "Writing",
        skillList = writing
    ),
    GenreWithSkills(
        genre = "Business & Finance",
        skillList = business
    ),
    GenreWithSkills(
        genre = "Sales & Ops",
        skillList = sales
    ),
)