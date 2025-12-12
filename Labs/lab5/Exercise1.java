import java.util.*;

public class Exercise1 {

   public static void main(String[] args) {

      InMemoryWorldDao countryDao = InMemoryWorldDao.getInstance();


      countryDao.findAllCountries().stream()
         .map(Country::getCities)
         .filter(Objects::nonNull)
         .map(cityList -> cityList.stream()
               .max(Comparator.comparing(City::getPopulation))
               .orElse(null))
         .filter(Objects::nonNull)
         .forEach(highestCity -> 
             System.out.println(highestCity.getName() + " : " + highestCity.getPopulation())
         );
   }
}