package fr.simplon.picone;

import fr.simplon.picone.controller.AdminController;
import fr.simplon.picone.controller.EstablishmentController;
import fr.simplon.picone.controller.MoodController;
import fr.simplon.picone.controller.WordController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PiconeApplicationTests {

	@Autowired
	private AdminController adminController;

	@Autowired
	private EstablishmentController establishmentController;

	@Autowired
	private MoodController moodController;

	@Autowired
	private WordController wordController;

	@Test
	void contextLoads() {
		assertThat(establishmentController).isNotNull();
		assertThat(moodController).isNotNull();
		assertThat(wordController).isNotNull();
	}

}
