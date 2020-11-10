package com.fabrikam;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DailyMessage {
    public static void main(String[] args) throws IOException {
        String todaysMessage = new DailyMessage().getTodaysMessage();
        System.out.println(todaysMessage);
        new SendThatText().sendMessage(todaysMessage);
    }

    public String getTodaysMessage() throws IOException {
        LocalDate today = LocalDate.now(Config.MY_TIMEZONE);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd");
        String todaysDate = today.format(dateFormatter);
        Wttr.WttrResult wttr = new Wttr().getTodaysWeather();
        String affirmation = new Affirmation().getAffirmation();

        return String.format(
                "%s Good Morning!  %s \n" +
                        "It's %s %s\n" +
                        "Today's temperature is:🌡%s" +
                        "%s\n" +
                        "\n♡ Have a good day! ♡",
                wttr.weather, wttr.weather,
                        todaysDate, wttr.moonPhase,
                        wttr.temperature,
                        affirmation
        );

    }
}