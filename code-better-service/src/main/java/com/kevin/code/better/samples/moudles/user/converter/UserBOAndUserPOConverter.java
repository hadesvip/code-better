package com.kevin.code.better.samples.moudles.user.converter;

import com.kevin.code.better.common.domain.Converter;
import com.kevin.code.better.samples.moudles.user.domain.bo.UserBO;
import com.kevin.code.better.samples.moudles.user.domain.dto.UserDTO;
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
