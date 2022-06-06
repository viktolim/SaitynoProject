package lt.viko.eif.vvilimaite.project;

import lt.viko.eif.vvilimaite.project.constructor.Film;
import lt.viko.eif.vvilimaite.project.constructor.FilmDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class FilmRequest {
    static protected ArrayList<Film> films;
    public static void main(String[] args)throws IOException,InterruptedException {

        Integer goodAnswer = 0 + (int)(Math.random() * 4);
        /**
         * Fetch all found movie data
         */
        System.out.println("??????????????????Gues what movie is ?????????????????????");
        System.out.println(films.get(goodAnswer).getImgUrl());
        for (int i = 0; i < 4; i++) {
            System.out.println(i+1+"- "+ films.get(i).getFilmName());
        }
        System.out.println("*********************************************");
        System.out.println("*********************************************");
        System.out.println("*********************************************");
        System.out.println("*********************************************");
        System.out.println("*********************************************");
        System.out.println("*********************************************");
        System.out.println("Ats.: "+films.get(goodAnswer).getFilmName());
    }
    public ArrayList<Film> getFilms() throws IOException, InterruptedException {
        films=new ArrayList<>();
        /**
         * Responsible to generate random number to find film by specific id (example: tt0944947) from server
         */
        Random rand = new Random();
        Integer randomNumber;
        String code;
        while (films.size()!=4) {
            randomNumber=rand.nextInt(1000000);
            code="tt0"+randomNumber;
            Film film=FilmDao.getFilmData(code);
            if(film!=null) {
                films.add(FilmDao.getFilmData(code));
            }

        }
        return films;
    }
}
