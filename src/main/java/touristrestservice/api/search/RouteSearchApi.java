package touristrestservice.api.search;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import touristrestservice.config.Constants;
import touristrestservice.model.entities.Route;

import java.sql.Date;
import java.util.List;

@RequestMapping(Constants.BASE_API_PATH)
public interface RouteSearchApi {

    @GetMapping(value = "/search/routes/section/{id}", produces = "application/json")
    List<Route> getRoutesBySection(@PathVariable("id") Long sectionId);

    @GetMapping(value = "/search/routes/date/{date}")
    List<Route> getRoutesByDate(@PathVariable Date date);

    @GetMapping(value = "/search/routes/instructor/{id}")
    List<Route> getRoutesByInstructor(@PathVariable("id") Long instructorId);

    @GetMapping(value = "/search/routes/trips")
    List<Route> getRoutesByTripsCount(@RequestParam("count") Integer tripsCount);

    @GetMapping(value = "/search/routes/place/{id}")
    List<Route> getRoutesByPlace(@PathVariable("id") Long placeId);

    @GetMapping(value = "/search/routes/length")
    List<Route> getRoutesByMinLengthKm(@RequestParam("min") Integer lengthKm);
}
