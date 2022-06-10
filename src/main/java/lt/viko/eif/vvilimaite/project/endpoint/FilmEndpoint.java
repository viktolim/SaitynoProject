package lt.viko.eif.vvilimaite.project.endpoint;

import lt.viko.eif.vvilimaite.project.FilmRequest;
import lt.viko.eif.vvilimaite.project.constructor.Film;
import lt.viko.eif.vvilimaite.project.constructor.FilmDao;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

public class FilmEndpoint {

    /**
     * endpoints to get needed information about films
     */
    @RestController
    @RequestMapping(value = "film")
    public class MealController {

        @GetMapping(value = "all")
        public Film fetchMeals() throws IOException, InterruptedException {
            FilmRequest filmRequest = new FilmRequest();
            System.out.println(FilmDao.getFilmData("tt0944947").toString());
            return null;
        }
    }
}
