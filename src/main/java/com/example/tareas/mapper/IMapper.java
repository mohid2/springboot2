package com.example.tareas.mapper;

public interface IMapper<T,K> {
    public K map(T in);
}
