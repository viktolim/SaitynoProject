package lt.viko.eif.vvilimaite.project.endpoint;

import lt.viko.eif.vvilimaite.project.constructor.Film;
import lt.viko.eif.vvilimaite.project.constructor.FilmDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(value="film")
public class FilmController {

@GetMapping(value="size={size}")
public List<Film> fetchFilms() throws IOException, InterruptedException {

    return FilmDao.fetchRandomFilms(2);
}
}
