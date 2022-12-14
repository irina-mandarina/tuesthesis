package com.example.demo.services

import com.example.demo.entities.CountryEntity
import com.example.demo.models.responseModels.Country
import com.example.demo.repositories.CountryRepository
import org.springframework.stereotype.Service

@Service
class CountryService(private val countryRepository: CountryRepository) {
    fun findCountryByCountryCode(countryCode: String): CountryEntity {
        return countryRepository.findCountryByCountryCode(countryCode)
    }

    fun countryFromEntity(country: CountryEntity): Country {
        return Country (
            country.countryCode,
            country.countryName,
            country.capital,
            country.area,
            country.continent
        )
    }
}