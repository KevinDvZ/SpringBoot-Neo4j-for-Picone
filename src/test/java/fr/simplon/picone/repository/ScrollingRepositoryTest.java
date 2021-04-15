package fr.simplon.picone.repository;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@DataNeo4jTest
public class ScrollingRepositoryTest {


    @Autowired
    private ScrollingRepository scrollingRepository;



}
