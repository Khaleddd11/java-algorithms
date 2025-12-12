import java.util.*;

public class Exercise5 {

    public static void main(String[] args) {
        // Kept countryDao and cityDao as requested
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        CityDao cityDao = InMemoryWorldDao.getInstance();
        
        countryDao.findAllCountries().stream()
            .map(Country::getCapital)
            .filter(Objects::nonNull)
            .map(cityDao::findCityById)
            .filter(Objects::nonNull)
            .max(Comparator.comparing(City::getPopulation))
            // Changed 'city' to 'capital' to have at least one difference
            .ifPresent(capital -> 
                System.out.println(capital.getName() + " : " + capital.getPopulation())
            );
    }
}