package fr.simplon.picone.repository;

import fr.simplon.picone.model.Establishment;
import fr.simplon.picone.model.Patient;
import fr.simplon.picone.model.Word;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface WordRepository extends Neo4jRepository<Word, Long> {


    @Query("MATCH (w:Word)-[r]->(m:Word) WHERE id(w)= $id  AND type(r)= $relation return m")
    List<Word> findChildNodes(@Param("relation") String relation, @Param("id") Long id);

    @Query("CREATE (m:Word{ word: :wordParam.word, img_url: :wordParam.imgUrl} )")
    Word addIcon(@Param("wordParam")Word word);

    //RELATION "besoins physiologiques"
    @Query("MATCH (n) WHERE id(n)=$id1 MATCH (m) WHERE id(m)=$id2 CREATE (n)-[r:besoins_physiologiques]->(m)")
    Word createIconRelation(Long id1, Long id2);

    /*@Query("updateIcon n SET n.img_url = :imgUrl WHERE n.id = :id")
    @Modifying
    public Long updateIcon(@Param("imgUrl")String imgUrl, @Param("id") Long id);*/

    @Query("MERGE (n:Word{ word: :wordParam.word, img_url: :wordParam.imgUrl} ) WHERE id(n)=$id SET n.word = :word, n.img_url = :imgUrl")
    @Modifying
    public Long updateIcon(@Param("word")String word, @Param("imgUrl")String imgUrl, @Param("id") Long id);

    @Query("START n = node({id}) OPTIONAL MATCH n-[r]-() DELETE n,r")
    void deleteIconAndHisRelationship(Long id);

    /*@Query("MATCH (n:Word) WHERE id(n)= $id  MATCH (n:Mot) WHERE id(n)= $id2 CREATE (n)-[r]->(m) WHERE labels(r)= $relation return r")
    Word createRelation(Long id1, Long id2, String relation);*/

}
