package efs.task.collections.data;

import efs.task.collections.entity.Hero;
import efs.task.collections.entity.Town;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataProvider {

    public static final String DATA_SEPARATOR = ",";

    // TODO Utwórz listę miast na podstawie tablicy Data.baseTownsArray.
    //  Tablica zawiera String zawierający nazwę miasta oraz dwie klasy bohatera związane z tym miastem oddzielone przecinkami.
    //  Korzystając z funkcji split() oraz stałej DATA_SEPARATOR utwórz listę obiektów klasy efs.task.collections.entities.Town.
    //  Funkcja zwraca listę obiektów typu Town ze wszystkimi dziewięcioma podstawowymi miastami.
    public List<Town> getTownsList() {
        List<Town> towns = new ArrayList<>();

        for(var town : Data.baseTownsArray) {
            var townName = town.split(DATA_SEPARATOR)[0].trim();
            var firstClass = town.split(DATA_SEPARATOR)[1].trim();
            var secondClass = town.split(DATA_SEPARATOR)[2].trim();
            List<String> classes = List.of(firstClass, secondClass);

            towns.add(new Town(townName, classes));
        }

        return towns;
    }

    //TODO Analogicznie do getTownsList utwórz listę miast na podstawie tablicy Data.DLCTownsArray
    public List<Town> getDLCTownsList() {
        List<Town> towns = new ArrayList<>();

        for(var town : Data.dlcTownsArray) {
            var townName = town.split(DATA_SEPARATOR)[0].trim();
            var firstClass = town.split(DATA_SEPARATOR)[1].trim();
            var secondClass = town.split(DATA_SEPARATOR)[2].trim();
            List<String> classes = List.of(firstClass, secondClass);

            towns.add(new Town(townName, classes));
        }

        return towns;
    }

    //TODO Na podstawie tablicy Data.baseCharactersArray utworzyć listę bohaterów dostępnych w grze.
    // Tablica Data.baseCharactersArray zawiera oddzielone przecinkiem imie bohatera, klasę bohatera.
    // Korzystając z funkcji split() oraz DATA_SEPARATOR utwórz listę unikalnych obiektów efs.task.collections.entities.Hero.
    // UWAGA w Data.baseCharactersArray niektórzy bohaterowie powtarzają się, do porównania bohaterów używamy zarówno imie jak i jego klasę;
    public Set<Hero> getHeroesSet() {
        // Set<Hero> heroes = new HashSet<>();

        // for(var hero : Data.baseCharactersArray) {
        //     var heroName = hero.split(DATA_SEPARATOR)[0].trim();
        //     var heroClass = hero.split(DATA_SEPARATOR)[1].trim();

        //     if(heroes.contains(new Hero(heroName, heroClass))) {
        //         continue;
        //     }

        //     heroes.add(new Hero(heroName, heroClass));
        // }

        Set<Hero> heroesSet = new HashSet<>();

        for (String heroData : Data.baseCharactersArray) {
            String[] heroDataArray = heroData.split(DATA_SEPARATOR);
            if (heroDataArray.length == 2) {
                String name = heroDataArray[0].trim();
                String heroClass = heroDataArray[1].trim();

                Hero hero = new Hero(name, heroClass);
                heroesSet.add(hero);
            }
        }

        return heroesSet;
    }

    //TODO Analogicznie do getHeroesSet utwórz listę bohaterów na podstawie tablicy Data.DLCCharactersArray
    public Set<Hero> getDLCHeroesSet() {
        Set<Hero> heroes = new HashSet<>();

        for(var hero : Data.dlcCharactersArray) {
            var heroName = hero.split(DATA_SEPARATOR)[0].trim();
            var heroClass = hero.split(DATA_SEPARATOR)[1].trim();

            if(heroes.contains(new Hero(heroName, heroClass))) {
                continue;
            }

            heroes.add(new Hero(heroName, heroClass));
        }

        return heroes;
    }
}