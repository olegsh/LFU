package org.olegsh.cache.lfu.api;

public interface ILfu {
  /*
  Least Frequently Used (LFU) is a caching algorithm in which
  the least frequently used cache block is removed whenever
  the cache is overflowed.
   */

  /**
   * put - put keys into LFU
   * @param data - Integer key
   * @return boolean
   */
  boolean put(Integer data);
  /**
   * isThere - check if key is there and if "yes" updates
   * the access to most recently used
   * @param data
   * @return boolean
   */
  boolean isThere(Integer data);

  /**
   * removeLast - removes last inserted key from LFU if exist
   * @return boolean
   */
  boolean removeLast();

  /**
   * remove specified key in the LFU
   * @param data
   * @return boolean
   */
  boolean remove(Integer data);

  /**
   * isFull - self described
   * @return
   */
  boolean isFull();

  String toString();
}
