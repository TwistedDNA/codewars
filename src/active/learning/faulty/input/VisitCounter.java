package active.learning.faulty.input;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

class VisitCounter {
    Map<Long, Long> count(Map<String, UserStats>... visits) {
        Map<Long, Long> visitsCountMap = new HashMap<>();
        if (visits == null || visits.length == 0) {
            return visitsCountMap;
        }

        for (int i = 0; i < visits.length; i++) {
            if (visits[i] == null) {
                continue;
            }
            Map<String, UserStats> singleServiceVisits = visits[i];
            singleServiceVisits.entrySet()
                    .stream().filter(filterNonParsableKeys())
                    .filter(entry -> entry.getValue() != null)
                    .filter(entry -> entry.getValue().getVisitCount().isPresent())
                    .forEach(addServiceStats(visitsCountMap));

        }
        return visitsCountMap;
    }
    private Predicate<Map.Entry<String, UserStats>> filterNonParsableKeys(){
        return entry -> {
            try {
                Long.parseLong(entry.getKey());
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };
    }
    private Consumer<Map.Entry<String, UserStats>> addServiceStats(Map<Long, Long> total){
        return entry -> {
            long serviceId = Long.parseLong(entry.getKey());
            long serviceVisits = entry.getValue().getVisitCount().orElse(0L);
            if(total.containsKey(serviceId)){
                total.put(serviceId, total.get(serviceId) + serviceVisits);
            }else{
                total.put(serviceId, serviceVisits);
            }
        };
    }
}

class UserStats {
    Optional<Long> getVisitCount() {
        return Optional.of(5L);
    }
}