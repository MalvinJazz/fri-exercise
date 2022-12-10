package com.soyfri.interview.demo.commons;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class CacheStore<K, T> {

	private Cache<K, T> cache;
	
	public CacheStore(int size, int expire) {
		
		this.cache = CacheBuilder.newBuilder()
				.maximumSize(size)
				.expireAfterWrite(expire, TimeUnit.DAYS)
				.build();
		
	}
	
	public void add(K id, T object) {
		cache.put(id, object);
	}
	
	public void remove(K id) {
		cache.invalidate(id);
	}
	
	public Optional<T> get(K id) {
		return Optional.ofNullable(cache.getIfPresent(id));
	}
	
}
