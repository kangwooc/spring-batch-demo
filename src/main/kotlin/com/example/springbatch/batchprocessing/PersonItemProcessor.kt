package com.example.springbatch.batchprocessing

import com.example.springbatch.LoggerConfig
import org.springframework.batch.item.ItemProcessor


class PersonItemProcessor: ItemProcessor<Person, Person> {
    private val logger = LoggerConfig.logger

    override fun process(person: Person): Person {
        val firstName: String = person.firstName.uppercase()
        val lastName: String = person.lastName.uppercase()

        val transformedPerson = Person(firstName, lastName)

        logger.info{ ("Converting ($person").toString() + ") into (" + transformedPerson + ")" }

        return transformedPerson
    }
}