package com.miit.ass4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainAss4 {
    public static void main(String[] args) {
//        MainAss4.createPost();
        findAuthor("Vishal Patel");

    }

    public static void findAuthor(String name){
        Session session = null;
        try( SessionFactory sessionFactory = new Configuration().configure("hibernate_cgf.xml")
                .buildSessionFactory()) {
            session = sessionFactory.openSession();
            session.beginTransaction();
            List<Author> authors = session.createQuery("from Author").getResultList();
            Optional<Author> result =  authors.stream().filter((author -> author.getName().equals(name))).findFirst();
            System.out.println("Result " + result.get().getName());
            session.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void createPost(){
        Session session = null;
        try( SessionFactory sessionFactory = new Configuration().configure("hibernate_cgf.xml")
                .buildSessionFactory()) {
            session = sessionFactory.openSession();
            session.beginTransaction();
            List<Post> posts = new ArrayList<>();
            Post post = new Post("Facebook");
            Post post1 = new Post("Twiteer");
            Post post2 = new Post("Insta");
            Post post4 = new Post("Linkedin");
            posts.add(post);
            posts.add(post1);
            posts.add(post2);
            posts.add(post4);

            Author author = new Author("Vishal Patel");
            author.setPosts(posts);
            Author author1 = new Author("Tushar Patel");
            author1.setPosts(posts);
            Author author2 = new Author("Jigar");
            author2.setPosts(posts);

            session.save(post);
            session.save(post1);
            session.save(post2);
            session.save(post4);

            session.save(author);
            session.save(author1);
            session.save(author2);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
