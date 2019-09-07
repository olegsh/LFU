package org.olegsh.cache.lfu.api;

public interface ILfu {
  /*
  Least Frequently Used (LFU) is a caching algorithm in which
  the least frequently used cache block is removed whenever
  the cache is overflowed.
   */
  boolean put(Integer data);
  boolean isThere(Integer data);
  boolean removeLast();
  boolean remove(Integer data);
  boolean isFull();
  String toString();
}
