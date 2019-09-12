package org.olegsh.cache.lfu.api.impl;

import org.olegsh.cache.lfu.api.ILfu;
import org.olegsh.cache.lfu.api.storage.Bucket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

public class LfuImpl implements ILfu {
  private static Logger logger = LoggerFactory.getLogger(LfuImpl.class);

  @Override
  public boolean put(Integer data) {
    Bucket bucket = Bucket.getInstance();
    try {
      if (data == null) {
        logger.error("put::Invalid input detected " + data);
        return false;
      }
      if ((bucket.getLinkedSet().isEmpty() ||
          !bucket.getLinkedSet().contains(data))
          && !isFull()) {
        bucket.getLinkedSet().add(data);
      } else if (bucket.getLinkedSet().contains(data)) {
        remove(data);
        bucket.getLinkedSet().add(data);
      } else if (isFull()) {
        // remove and add
        removeLast();
        bucket.getLinkedSet().add(data);
      }
    } catch (Exception ex ) {
      logger.error(ex.getMessage(), ex);
      return false;
    }
    return true;
  }

  @Override
  public boolean isThere(Integer data) {
    Bucket bucket = Bucket.getInstance();
    if (data == null) {
      logger.error("isThere::Invalid input detected " + data);
      return false;
    }
    if (bucket == null || bucket.getLinkedSet() == null
        || bucket.getLinkedSet().isEmpty()) {
      return false;
    }
    if (bucket.getLinkedSet().contains(data)) {
      remove(data);
      bucket.getLinkedSet().add(data);
      return true;
    }
    return false;
  }

  @Override
  public boolean removeLast() {
    Bucket bucket = Bucket.getInstance();
    if (bucket == null || bucket.getLinkedSet() == null ||
        bucket.getLinkedSet().isEmpty()) {
      logger.error("removeLast::LFU is empty");
      return false;
    }
    Object [] tmp = bucket.getLinkedSet().toArray();
    return bucket.getLinkedSet().remove(tmp[0]);
  }

  @Override
  public boolean remove(Integer data) {
    Bucket bucket = Bucket.getInstance();
    if (data == null) {
      logger.error("remove::Invalid input detected " + data);
      return false;
    }
    else {
      return bucket.getLinkedSet().remove(data);
    }
  }

  @Override
  public boolean isFull() {
    Bucket bucket = Bucket.getInstance();
    if (bucket.getLinkedSet().size() == bucket.getMaxSize()) {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    Bucket bucket = Bucket.getInstance();
    Iterator<Integer> iter = bucket.getLinkedSet().iterator();
    StringBuilder buf = new StringBuilder();
    while (iter.hasNext()) {
      buf.append(iter.next() + ";  ");
    }
    return buf.toString();
  }
}
