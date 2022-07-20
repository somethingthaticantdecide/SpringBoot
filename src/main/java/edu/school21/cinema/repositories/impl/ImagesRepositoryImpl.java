//package edu.school21.cinema.repositories.impl;
//
//import edu.school21.cinema.model.Image;
//import edu.school21.cinema.repositories.ImagesRepository;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Repository
//@Transactional
//public class ImagesRepositoryImpl implements ImagesRepository {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public void add(Image image) {
//        entityManager.persist(image);
//    }
//
//    @Override
//    public List<Image> getImages() {
//        return entityManager.createQuery(" from Image ", Image.class).getResultList();
//    }
//
//    @Override
//    public Image getImageById(Integer id) {
//        return entityManager.find(Image.class, id);
//    }
//
//    @Override
//    public Image getImageByName(String name) {
//        TypedQuery<Image> typedQuery = entityManager.createQuery(" from Image where filename=:name", Image.class);
//        typedQuery.setParameter("name", name);
//        return typedQuery.getResultList().get(0);
//    }
//}