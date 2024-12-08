package com.javaIntellij.Services;

import java.io.IOException;
import java.util.List;

public interface IMetier<T> {

        T add(T t);

        List<T> getAll() throws IOException, ClassNotFoundException;

        T findByNom(String nom);

        void delete(String nom);

        void saveAll();
}
