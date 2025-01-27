import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.swing.*;
import java.awt.*;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp {

    // Replace with your OpenWeatherMap API key
    private static final String API_KEY = "YOUR_API_KEY";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Weather Forecasting App");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            // Create components
            JTextField cityTextField = new JTextField();
            JButton fetchButton = new JButton("Get Weather");
            JTextArea weatherInfoArea = new JTextArea();
            weatherInfoArea.setEditable(false);

            // Add components to the frame
            frame.add(new JLabel("Enter City Name:"), BorderLayout.NORTH);
            frame.add(cityTextField, BorderLayout.CENTER);
            frame.add(fetchButton, BorderLayout.EAST);
            frame.add(new JScrollPane(weatherInfoArea), BorderLayout.SOUTH);

            // Fetch weather data when button is clicked
            fetchButton.addActionListener(e -> {
                String city = cityTextField.getText();
                if (!city.isEmpty()) {
                    String weatherData = getWeatherData(city);
                    weatherInfoArea.setText(weatherData);
                } else {
                    weatherInfoArea.setText("Please enter a city name.");
                }
            });

            // Show the frame
            frame.setVisible(true);
        });
    }

    // Fetch weather data from OpenWeatherMap API
    private static String getWeatherData(String city) {
        String result = "";
        try {
            String urlString = API_URL + city + "&appid=" + API_KEY + "&units=metric"; // units=metric for Celsius
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the response
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            JsonObject jsonResponse = JsonParser.parseReader(reader).getAsJsonObject();

            // Extract weather details
            String cityName = jsonResponse.get("name").getAsString();
            String temperature = jsonResponse.getAsJsonObject("main").get("temp").getAsString();
            String description = jsonResponse.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
            String humidity = jsonResponse.getAsJsonObject("main").get("humidity").getAsString();
            String windSpeed = jsonResponse.getAsJsonObject("wind").get("speed").getAsString();

            result = "Weather in " + cityName + ":\n";
            result += "Temperature: " + temperature + "°C\n";
            result += "Description: " + description + "\n";
            result += "Humidity: " + humidity + "%\n";
            result += "Wind Speed: " + windSpeed + " m/s\n";
        } catch (Exception e) {
            result = "Error fetching weather data. Please try again.";
            e.printStackTrace();
        }
        return result;
    }
}
