package org.olegsh.cache.lfu.api.storage;

import org.springframework.beans.factory.annotation.Value;

import java.util.LinkedHashSet;
import java.util.Set;

public class Bucket {
  private static Bucket bucketInstance = new Bucket();
  private Set<Integer> linkedSet;
  private final int MAX_SIZE = 5;

  public static Bucket getInstance() {
    // bucket should never be equal to null, but just in case...
    if(bucketInstance == null) {
      bucketInstance = new Bucket();
    }
    return bucketInstance;
  }

  private Bucket() {
    this.linkedSet = new LinkedHashSet<>(MAX_SIZE);
  }
  public Set<Integer> getLinkedSet() { return linkedSet; }
  public void setLinkedSet(Set<Integer> linkedSet) {
    this.linkedSet = linkedSet;
  }
  public int getMaxSize() { return this.MAX_SIZE; }
}
