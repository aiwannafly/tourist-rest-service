package touristrestservice.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import touristrestservice.api.search.RouteSearchApi;
import touristrestservice.model.entities.Route;
import touristrestservice.service.RouteService;

import java.sql.Date;
import java.util.List;

@RestController
public class RouteSearchController implements RouteSearchApi {
    private RouteService routeService;

    @Autowired
    void setRouteService(RouteService routeService) {
        this.routeService = routeService;
    }

    @Override
    public List<Route> getRoutesBySection(Long sectionId) {
        return routeService.getRoutesBySection(sectionId);
    }

    @Override
    public List<Route> getRoutesByDate(Date date) {
        return routeService.getRoutesByDate(date);
    }

    @Override
    public List<Route> getRoutesByInstructor(Long instructorId) {
        return routeService.getRoutesByInstructor(instructorId);
    }

    @Override
    public List<Route> getRoutesByTripsCount(Integer tripsCount) {
        return routeService.getRoutesByTripsCount(tripsCount);
    }

    @Override
    public List<Route> getRoutesByPlace(Long placeId) {
        return routeService.getRoutesByPlace(placeId);
    }

    @Override
    public List<Route> getRoutesByMinLengthKm(Integer lengthKm) {
        return routeService.getRoutesByMinLengthKm(lengthKm);
    }
}
