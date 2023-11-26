package com.gabriella.itschool.services;

import com.gabriella.itschool.models.entities.Weather;

import java.io.IOException;

public interface WeatherService {

    Weather getWeather(String city) throws IOException;
}
