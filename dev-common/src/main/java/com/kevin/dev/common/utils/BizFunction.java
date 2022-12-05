package com.kevin.dev.common.utils;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 业务Function
 *
 * @author kevin
 */
public interface BizFunction<T, R> extends Function<T, R> {

  @Override
  default <V> BizFunction<T, V> andThen(Function<? super R, ? extends V> after) {
    Objects.requireNonNull(after);
    return (T t) -> after.apply(apply(t));
  }

  /**
   * 条件判断
   *
   * @param condition     条件
   * @param trueFunction  正确执行
   * @param falseFunction 错误执行
   * @param <V>
   * @return
   */
  default <V> BizFunction<T, V> conditionThen(Predicate<R> condition, Function<R, V> trueFunction,
      Function<R, V> falseFunction) {
    return t -> {
      R result = apply(t);
      return condition.test(result) ? trueFunction.apply(result) : falseFunction.apply(result);
    };
  }

  /**
   * 条件判断，如果满足条件则执行传入的function，否则不处理
   *
   * @param condition    条件
   * @param trueFunction 正确执行方法
   * @return
   */
  default BizFunction<T, R> conditionThen(Predicate<R> condition, Function<R, R> trueFunction) {
    return r -> {
      R result = apply(r);
      return condition.test(result) ? trueFunction.apply(result) : result;
    };
  }

  /**
   * 根据条件判断构建方法
   *
   * @param condition     条件
   * @param trueFunction  正确执行
   * @param falseFunction 错误执行
   * @param <A>           传入参数
   * @param <B>           输出参数
   * @return
   */
  static <A, B> BizFunction<A, B> conditionFunc(Predicate<A> condition, Function<A, B> trueFunction,
      Function<A, B> falseFunction) {
    return a -> condition.test(a) ? trueFunction.apply(a) : falseFunction.apply(a);
  }

  /**
   * 根据条件判断构建方法
   *
   * @param condition    条件
   * @param trueFunction 正确执行
   * @param <A>          传入参数和输出参数
   * @return
   */
  static <A> BizFunction<A, A> conditionFunc(Predicate<A> condition, Function<A, A> trueFunction) {
    return a -> condition.test(a) ? trueFunction.apply(a) : a;
  }

  /**
   * 返回传入参数本身
   *
   * @param <T>
   * @return
   */
  static <T> BizFunction<T, T> identity() {
    return t -> t;
  }
}
