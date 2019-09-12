package org.olegsh.cache.lfu.api.impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.olegsh.cache.lfu.api.ILfu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LfuImplTest {
  private static Logger logger = LoggerFactory.getLogger(LfuImpl.class);
  private ILfu cacheService;

  @BeforeAll
  public void init() {
    cacheService = new LfuImpl();
    assertEquals(true,cacheService.put(5));
    assertEquals(true,cacheService.put(7));
    assertEquals(true,cacheService.put(12));
    assertEquals(true,cacheService.put(23));
    assertEquals(true,cacheService.put(19));
    logger.info("ORIG: " + cacheService.toString());
  }

  @AfterAll
  public void detroy() {
    cacheService = null;
  }

  @Test
  public void testPutToLFU() throws Throwable {
    assertTrue(cacheService.isFull());
  }

  @Test
  public void testAddToFull() throws Throwable {
    assertEquals(true, cacheService.put(27));
    logger.debug("Insert 27:  " + cacheService.toString());
    assertEquals(true, cacheService.put(29));
    logger.debug("Insert 29:  " + cacheService.toString());
  }

  @Test
  public void updateValue() throws Throwable {
    logger.debug("before: " + cacheService.toString());
    cacheService.isThere(5);
    logger.debug("after: " + cacheService.toString());
  }

  @Test
  void put() {
  }

  @Test
  void isThere() {
  }

  @Test
  void removeLast() {
  }

  @Test
  void remove() {
  }

  @Test
  void isFull() {
  }

  @Test
  void testToString() {
  }
}