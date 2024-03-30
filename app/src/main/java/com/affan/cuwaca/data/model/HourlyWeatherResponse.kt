package com.affan.cuwaca.data.model

import com.google.gson.annotations.SerializedName

data class HourlyWeatherResponse(
    @SerializedName("cod")
    val cod: String,
    @SerializedName("message")
    val message: Int,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("list")
    val forecastDataList: List<ForecastDataHourly>
)

data class ForecastDataHourly(
    @SerializedName("dt")
    val dt: Long,
    @SerializedName("main")
    val main: MainHourly,
    @SerializedName("weather")
    val weather: List<WeatherHourly>,
    @SerializedName("clouds")
    val clouds: CloudsHourly,
    @SerializedName("wind")
    val wind: WindHourly,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("pop")
    val pop: Double,
    @SerializedName("rain")
    val rain: Rain?,
    @SerializedName("sys")
    val sys: SysHourly,
    @SerializedName("dt_txt")
    val dtTxt: String
)

data class MainHourly(
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("temp_min")
    val tempMin: Double,
    @SerializedName("temp_max")
    val tempMax: Double,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("sea_level")
    val seaLevel: Int,
    @SerializedName("grnd_level")
    val grndLevel: Int,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("temp_kf")
    val tempKf: Double
)

data class WeatherHourly(
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String
)

data class CloudsHourly(
    @SerializedName("all")
    val all: Int
)

data class WindHourly(
    @SerializedName("speed")
    val speed: Double,
    @SerializedName("deg")
    val deg: Int,
    @SerializedName("gust")
    val gust: Double
)

data class Rain(
    @SerializedName("3h")
    val h3: Double
)

data class SysHourly(
    @SerializedName("pod")
    val pod: String
)