package com.kevin.dev.common.domain;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * bean转换器
 *
 * @author wangyong
 */
public class Converter<F, T> {

  private final Function<F, T> formDTO;
  private final Function<T, F> fromEntity;

  public Converter(final Function<F, T> formDTO, final Function<T, F> fromEntity) {
    this.formDTO = formDTO;
    this.fromEntity = fromEntity;
  }


  public final T convertFromDTO(final F dto) {
    return formDTO.apply(dto);
  }

  public final F convertFromEntity(final T entity) {
    return fromEntity.apply(entity);
  }


  public final List<T> createFromDTOList(final Collection<F> dtoList) {
    return dtoList.stream().map(this::convertFromDTO).collect(Collectors.toList());
  }

  public final List<F> createFromEntityList(final Collection<T> entityList) {
    return entityList.stream().map(this::convertFromEntity).collect(Collectors.toList());
  }


}
