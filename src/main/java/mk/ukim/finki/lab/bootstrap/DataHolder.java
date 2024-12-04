package mk.ukim.finki.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.EventBooking;
import mk.ukim.finki.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events=null;
    public static List<EventBooking> bookedEvents=null;
    public static List<Location> locations=null;

    @PostConstruct
    public void init(){

        Location location1 = new Location("Central Park", "New York, NY", "5000", "A large public park in New York City, perfect for concerts and outdoor events.");
        Location location2 = new Location("Eiffel Tower", "Paris, France", "2000", "Iconic Parisian landmark with a beautiful view, popular for tourism and events.");
        Location location3 = new Location("Sydney Opera House", "Sydney, Australia", "1500", "Famous performing arts venue with unique architecture on the harbor.");
        Location location4 = new Location("Tokyo Dome", "Tokyo, Japan", "55000", "Massive stadium in Tokyo, used for sports and music events.");
        Location location5 = new Location("Grand Canyon", "Arizona, USA", "Unlimited", "A breathtaking natural landscape, suitable for large tours and sightseeing.");
        events = new ArrayList<>();

        events.add(new Event("Music Festival", "An open-air music event with various artists.", 8.9,location1));
        events.add(new Event("Food Expo", "A showcase of cuisines from around the world.", 7.5,location1));
        events.add(new Event("Art Exhibition", "An exhibition featuring modern art pieces.", 6.8,location2));
        events.add(new Event("Science Fair", "An event showcasing science projects from students.", 9.0,location3));
        events.add(new Event("Tech Conference", "A conference with talks on new tech trends.", 8.3,location4));
        events.add(new Event("Film Screening", "A screening of award-winning short films.", 7.1,location5));
        events.add(new Event("Book Fair", "A gathering for book enthusiasts with author readings.", 6.5,location3));
        events.add(new Event("Marathon", "A charity run to raise funds for health initiatives.", 8.0,location5));
        events.add(new Event("Comedy Show", "A live stand-up comedy show.", 7.9,location2));
        events.add(new Event("Gaming Convention", "A convention for video game fans and industry experts.", 8.7,location3));
        bookedEvents=new ArrayList<>();
        locations=new ArrayList<>();
        locations.add(location1);
        locations.add(location2);
        locations.add(location3);
        locations.add(location4);
        locations.add(location5);
    }
}
