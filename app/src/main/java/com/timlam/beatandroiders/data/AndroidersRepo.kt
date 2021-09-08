package com.timlam.beatandroiders.data

import com.timlam.beatandroiders.R

object AndroidersRepo {

    fun getAndroiders(): List<Androider> = listOf(
        Androider(
            id = 1,
            firstName = "Christoforos",
            lastName = "Kolovos",
            title = "Engineering Manager - Android Passenger",
            description = "Sayed you are fired!",
            image = R.drawable.christofors,
            hint = "Sayed, don't know if you can hear me (because of your connection), but you are fired!"
        ),
        Androider(
            id = 2,
            firstName = "Aristofanis",
            lastName = "Zisis",
            title = "Engineering Manager - Android Driver",
            description = "The Schwarzenegger of Android Community",
            image = R.drawable.aris,
            hint = "Does anybody have any peanut butter left over?"
        ),
        Androider(
            id = 3,
            firstName = "George",
            lastName = "Theocharis",
            title = "Staff Engineer - Android",
            description = "TDD maniac",
            image = R.drawable.george,
            hint = "Where is my 6th coffee? Can't work like this!"
        ),
        Androider(
            id = 4,
            firstName = "Timoleon",
            lastName = "Lamprinos",
            title = "Android Engineer",
            description = "CEO",
            image = R.drawable.timos,
            hint = "Show some respect to your CEO!"
        ),
        Androider(
            id = 5,
            firstName = "Vladimir",
            lastName = "Petrosvki",
            title = "Senior Android Engineer - Infrastructure",
            description = "What's up",
            image = R.drawable.vlad,
            hint = "Almost hit an eagle in my 6th skydiving jump!"
        ),
        Androider(
            id = 6,
            firstName = "Gabriele",
            lastName = "Porcelli",
            title = "Senior Android Engineer",
            description = "Forza Italia!",
            image = R.drawable.gabriele,
            hint = "Forza Italia!"
        ),
        Androider(
            id = 7,
            firstName = "Luis",
            lastName = "Munoz",
            title = "Engineer Manager - Android Infrastructure",
            description = "What's up",
            image = R.drawable.luis,
            hint = "Cat where do you think you are going? Don' t leave me alone with Aris!"
        ),
        Androider(
            id = 8,
            firstName = "Sayed",
            lastName = "Elabady",
            title = "Android Engineer",
            description = "What's up",
            image = R.drawable.sayed,
            hint = "Let's send all the managers into exile and enjoy our lives!"
        ),
        Androider(
            id = 9,
            firstName = "Haris",
            lastName = "Houlis",
            title = "Android Software Engineer",
            description = "What's up",
            image = R.drawable.haris,
            hint = "Why does time seem to flow only in one direction?"
        ),
        Androider(
            id = 10,
            firstName = "Marius",
            lastName = "Budin",
            title = "Android Engineer",
            description = "What's up",
            image = R.drawable.marius,
            hint = "What is going on with all these android slack channels?"
        ),
    )

    fun getAndroiderById(id: Int): Androider = getAndroiders().first { it.id == id }

}
