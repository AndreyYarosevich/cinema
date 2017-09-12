package cinema.services.impl;

import cinema.InMemmoryDataBaseSimulator;
import cinema.pojo.Event;
import cinema.services.EventService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class EventServiceImpl implements EventService {

    @Override
    public void save(Event event) {
        InMemmoryDataBaseSimulator.events.add(event);
    }

    @Override
    public void remove(Event event) {
        InMemmoryDataBaseSimulator.events.remove(event);
    }

    @Override
    public Event getById(long id) {
        Optional<Event> eventOptional = InMemmoryDataBaseSimulator.events.stream()
                .filter(e -> e.getId() == id)
                .findFirst();

        return eventOptional.orElse(new Event());
    }

    @Override
    public Event getByName(String name) {
        Optional<Event> eventOptional = InMemmoryDataBaseSimulator.events.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst();

        return eventOptional.orElse(new Event());
    }

    @Override
    public List<Event> getAll() {

        return InMemmoryDataBaseSimulator.events;
    }

    @Override
    public List<Event> getForDateRange(LocalDateTime from, LocalDateTime to) {
        List<Event> events = InMemmoryDataBaseSimulator.events.stream()
                .filter(e -> {
                    long start = from.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                    long finish = to.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                    long current = e.getDate().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

                    return current >= start && current <= finish;
                }).collect(Collectors.toList());

        return events;
    }

    @Override
    public List<Event> getNextEvents(LocalDateTime to) {
        List<Event> events = InMemmoryDataBaseSimulator.events.stream()
                .filter(e -> {
                    long finish = to.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                    long current = e.getDate().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

                    return current <= finish;
                }).collect(Collectors.toList());

        return events;
    }
}
