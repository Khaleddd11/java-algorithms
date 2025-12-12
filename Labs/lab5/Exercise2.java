import java.util.Comparator;
import java.util.stream.Collectors;

public class Exercise2 {
    public static void main(String[] args) {

        // Kept 'countryDao'
        CountryDao countryDao = InMemoryWorldDao.getInstance();

        countryDao.findAllCountries().stream()
            .collect(Collectors.groupingBy(Country::getContinent))
            .forEach((continent, countries) -> { 
                countries.stream()
                    .flatMap(entry -> entry.getCities().stream())
                    .max(Comparator.comparing(City::getPopulation))
                    .ifPresent(result -> 
                        System.out.println(continent + " : " + result.getName() + " : " + result.getPopulation())
                    );
            });
    }
}