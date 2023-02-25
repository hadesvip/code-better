package com.kevin.code.better.samples;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * Java8 中并发流
 * Stream 流在执行时候是串行化的
 * ParallelStream 是一种并行流，处理任务时并行处理,前提是多核CPU，才会并行处理。
 *
 * @author kevin
 */
public class ParallelStreamTest {


  @org.junit.jupiter.api.Test
  public void parallelStreamTest() {
    //串行执行
    IntStream.range(1, 8).forEach(System.out::println);
    Logger.getGlobal().info("=====================");
    //随机执行
    IntStream.range(1, 8).parallel().forEach(System.out::println);
  }

  @Test
  public void threadSecurityProblemTest() {
    //ArrayList线程非安全，多线程操作场景会出现问题
    List<Integer> correctNums = Lists.newArrayList();
    List<Integer> errorNums = Lists.newArrayList();

    int count = 1000;
    for (int i = 0; i < count; i++) {
      correctNums.add(i);
    }

    correctNums.parallelStream().forEach(errorNums::add);

    Logger.getGlobal().info("correctNums对应的size:" + correctNums.size());
    Logger.getGlobal().info("errorNums对应的size:" + errorNums.size());
  }


  @Test
  public void threadSecurityProblemFixTest() {
    //ArrayList线程非安全，多线程操作场景会出现问题
    List<Integer> correctNums = Lists.newArrayList();
    List<Integer> errorNums = Lists.newCopyOnWriteArrayList();

    int count = 1000;
    for (int i = 0; i < count; i++) {
      correctNums.add(i);
    }

    correctNums.parallelStream().forEach(errorNums::add);

    Logger.getGlobal().info("correctNums对应的size:" + correctNums.size());
    Logger.getGlobal().info("errorNums对应的size:" + errorNums.size());
  }
}
