Weather Forecasting Application
Overview
The Weather Forecasting Application is a Java-based desktop application that fetches real-time weather data for a given city using the OpenWeatherMap API. The app allows users to enter a city name and view the current weather conditions, including temperature, humidity, wind speed, and a brief weather description.

Features
Real-time Weather Data: Displays the current weather for a city, including temperature, humidity, wind speed, and weather description.
City Search: Users can search for weather data by entering the name of a city.
Unit Conversion: The temperature is displayed in Celsius by default.
Error Handling: Displays error messages for invalid city names or network issues.
Technologies Used
Java: Core Java for the backend logic and Swing for the graphical user interface (GUI).
OpenWeatherMap API: Used to fetch real-time weather data.
Gson: A Java library for parsing JSON data from the API response.
Prerequisites
Before running the application, ensure you have the following:

Java 8 or higher installed on your machine.
Maven (optional, if using Maven for dependency management).
OpenWeatherMap API key: You need to sign up at OpenWeatherMap and get an API key.
Setup Instructions
1. Clone the repository
Clone this repository to your local machine using the following command:

bash
Copy
Edit
git clone https://github.com/your-username/weather-forecasting-app.git
2. Add Gson dependency (if using Maven)
If you are using Maven, add the following dependency to your pom.xml file:

xml
Copy
Edit
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.8</version>
</dependency>
If you are not using Maven, download the Gson JAR file and add it to your project's classpath.

3. Replace API Key
Replace the YOUR_API_KEY placeholder in the WeatherApp.java file with your actual API key from OpenWeatherMap:

private static final String API_KEY = "YOUR_API_KEY";
5. Compile and Run
Compile and run the WeatherApp.java file:

bash
javac WeatherApp.java
java WeatherApp
5. Use the Application
Enter a city name in the input field.
Click the "Get Weather" button to fetch the current weather data.
The weather details (temperature, humidity, wind speed, etc.) will be displayed in the text area.

Example Output
For the city "London", the application might display the following output:

yaml
Weather in London:
Temperature: 15.0°C
Description: clear sky
Humidity: 72%
Wind Speed: 3.6 m/s

Error Handling
If the city name is invalid or if there is an issue with the network, the application will display an error message.
