import com.google.inject.Binder;
import com.google.inject.assistedinject.FactoryModuleBuilder;

import com.tapatron.reg.video.Genre;
import com.tapatron.reg.video.GenreResource;
import com.tapatron.reg.video.GenreService;
import com.tapatron.reg.video.Movie;
import com.tapatron.reg.video.MoviesResource;
import com.tapatron.reg.video.MoviesResourceFactory;
import com.tapatron.reg.video.MoviesService;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import utils.JettyGuiceRestEasyTest;

import static org.assertj.core.api.Assertions.assertThat;

public class MoviesServiceTest extends JettyGuiceRestEasyTest {
    private static final String BASE_URL = "http://localhost:9000";

    @Override
    protected void configure(Binder b) {
        b.bind(GenreResource.class).to(GenreService.class);
        b.install(new FactoryModuleBuilder()
            .implement(MoviesResource.class, MoviesService.class)
            .build(MoviesResourceFactory.class));
    }

    @Test
    public void getsTheGenre() {
        Client client = ClientBuilder.newClient();
        assertThat(client.target(BASE_URL)
                .path("/genre/horror")
                .request()
                .get(Genre.class).getName()).isEqualTo("horror");
    }

    @Test
    public void getsTheMovie() {
        Client client = ClientBuilder.newClient();
        assertThat(client.target(BASE_URL)
            .path("/genre/horror/movies/31")
            .request()
            .get(Movie.class).getName()).isEqualTo("Jaws");
    }

    @Test
    public void getsTheGenreUsingClientProxy() throws Exception {
        ResteasyClient resteasyClient = new ResteasyClientBuilder().build();
        GenreResource genreResource = resteasyClient.target(BASE_URL).proxy(GenreResource.class);

        Genre genre = genreResource.genre("horror");

        assertThat(genre.getName()).isEqualTo("horror");
    }

    @Test
    public void getsTheMovieSubResourceUsingClientProxy() throws Exception {
        ResteasyClient resteasyClient = new ResteasyClientBuilder().build();
        GenreResource genreResource = resteasyClient.target(BASE_URL).proxy(GenreResource.class);

        Movie movie = genreResource.moviesResource("horror").movie(31);

        assertThat(movie.getName()).isEqualTo("Jaws");
    }
}
