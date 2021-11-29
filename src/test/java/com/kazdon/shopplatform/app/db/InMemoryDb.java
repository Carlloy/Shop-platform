package com.kazdon.shopplatform.app.db;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InMemoryDb<T, V> {
    private final Map<T, V> db = new ConcurrentHashMap<>();

    public void save(Function<V, T> id, V object) {
        db.put(id.apply(object), object);
    }

    public void update(Function<V, T> id, V object) {
        db.remove(id.apply(object));
        db.put(id.apply(object), object);
    }

    public V get(T id) {
        return db.get(id);
    }

    public Optional<V> getOptional(T id) {
        return Optional.of(db.get(id));
    }

    public Collection<V> getAll(Collection<T> ids) {
        return db.entrySet().stream()
                .filter(e -> ids.contains(e.getKey()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public Collection<V> getAll() {
        return db.values();
    }

    public void deleteByFieldValue(Function<V, ?> fieldGetter, Object fieldValue) {
        db.entrySet().stream()
                .filter(entry -> fieldGetter.apply(entry.getValue()).equals(fieldValue))
                .forEach(entry -> db.remove(entry.getKey()));
    }

    public Collection<V> findByFieldValue(Function<V, ?> fieldGetter, Object fieldValue) {
        return db.values().stream()
                .filter(v -> fieldGetter.apply(v).equals(fieldValue))
                .collect(Collectors.toList());
    }

    public void delete(T id) {
        db.remove(id);
    }

    public void clear() {
        db.clear();
    }
}
