package com.kevin.code.better.samples.moudles.user.converter;

import com.kevin.code.better.samples.moudles.user.domain.bo.UserBO;
import com.kevin.code.better.samples.moudles.user.domain.dto.UserDTO;
import com.kevin.dev.common.domain.Converter;
import java.util.function.Function;


/**
 * userBO->UserPO
 */
public class UserBOAndUserPOConverter extends Converter<UserBO, UserDTO> {


  public UserBOAndUserPOConverter(
      Function<UserBO, UserDTO> formDTO,
      Function<UserDTO, UserBO> fromEntity) {
    super(formDTO, fromEntity);
  }
}
